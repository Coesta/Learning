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
import com.arctouch.codechallenge.api.RetrofitConfig
import com.arctouch.codechallenge.api.RetrofitConfig.Companion.api
import com.arctouch.codechallenge.api.RetrofitConfig.Companion.getUpcomingMovies
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        connectionText = findViewById(R.id.connection_off_text)
        recyclerView = findViewById(R.id.recyclerView)
        homeAdapter = HomeAdapter(emptyList<Movie>().toMutableList(), this)
        manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        infiniteScrollListener = InfiniteScrollListener(manager, this)
        infiniteScrollListener.setLoaded()
        recyclerView.addOnScrollListener(infiniteScrollListener)

        if (verifyAvailableNetwork(this)) {
            connectionText.visibility = View.GONE
            getGenres()
        } else
            connectionText.visibility = View.VISIBLE
    }

    private fun getGenres() {
        api.genres(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Cache.cacheGenres(it.genres)
                    getUpcomingMovies()
                }
    }

    private fun getUpcomingMovies() {
        moviesWithGenres = getNewPage()
        recyclerView.adapter = HomeAdapter(moviesWithGenres, this)
        progressBar.visibility = View.GONE
    }

    private fun getNewPage(): MutableList<Movie> {
        pageCounter++
        return getUpcomingMovies(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE, pageCounter, TmdbApi.DEFAULT_REGION)
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, DetailMovieActivity::class.java)
        val movie: Movie = moviesWithGenres.get(position)
        intent.putExtra(DetailMovieActivity.MOVIE_DETAIL, movie as Serializable)
        startActivity(intent)
    }

    override fun onLoadMore() {
        Handler().postDelayed({
            homeAdapter.addData(getNewPage())
            infiniteScrollListener.setLoaded()
        }, 2000)
    }
}
