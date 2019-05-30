package com.arctouch.codechallenge.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.adapters.HomeAdapter
import com.arctouch.codechallenge.api.RetrofitConfig.Companion.api
import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.data.Cache
import com.arctouch.codechallenge.listeners.InfiniteScrollListener
import com.arctouch.codechallenge.model.Movie
import com.arctouch.codechallenge.util.verifyAvailableNetwork
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.home_activity.*
import java.io.Serializable

class HomeActivity : AppCompatActivity(), HomeAdapter.OnItemListener, InfiniteScrollListener.OnLoadMoreListener {

    lateinit var moviesWithGenres: MutableList<Movie>
    lateinit var connectionText: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var manager: LinearLayoutManager
    lateinit var infiniteScrollListener: InfiniteScrollListener
    lateinit var homeAdapter: HomeAdapter
    var pageCounter: Long = 0
    var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        initViews()

        if (verifyAvailableNetwork(this)) {
            connectionText.visibility = View.GONE
            getGenres()
        } else
            connectionText.visibility = View.VISIBLE
    }

    private fun initViews() {
        connectionText = findViewById(R.id.connection_off_text)
        recyclerView = findViewById(R.id.recyclerView)
        homeAdapter = HomeAdapter(emptyList<Movie>().toMutableList(), this)
        recyclerView.adapter = homeAdapter
        manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        infiniteScrollListener = InfiniteScrollListener(manager, this)
        infiniteScrollListener.setLoaded()
        recyclerView.addOnScrollListener(infiniteScrollListener)
    }

    private fun getGenres() {
        api.genres(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Cache.cacheGenres(it.genres)
                    getNewPage()
                }
    }

    private fun getNewPage() {
        pageCounter++
        position += 20
        getUpcomingMovies()
    }

    private fun getUpcomingMovies() {
        api.upcomingMovies(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE, pageCounter, "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    moviesWithGenres = it.results.map { movie ->
                        movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
                    }.toMutableList()
                    if (pageCounter == 1.toLong()){
                        homeAdapter = HomeAdapter(moviesWithGenres, this)
                        recyclerView.adapter = homeAdapter
                    } else {
                        homeAdapter.addData(moviesWithGenres)
                        manager.scrollToPosition(position)
                    }

                    progressBar.visibility = View.GONE
                }
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, DetailMovieActivity::class.java)
        val movie: Movie = moviesWithGenres.get(position)
        intent.putExtra(DetailMovieActivity.MOVIE_DETAIL, movie as Serializable)
        startActivity(intent)
    }

    override fun onLoadMore() {
        Handler().postDelayed({
            getNewPage()
            infiniteScrollListener.setLoaded()
        }, 0)
    }
}
