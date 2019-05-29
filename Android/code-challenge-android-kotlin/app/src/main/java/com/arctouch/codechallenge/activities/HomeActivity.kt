package com.arctouch.codechallenge.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.adapters.HomeAdapter
import com.arctouch.codechallenge.api.RetrofitConfig.Companion.api
import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.data.Cache
import com.arctouch.codechallenge.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.home_activity.*
import java.io.Serializable

class HomeActivity : AppCompatActivity(), HomeAdapter.OnItemListener {

    lateinit var moviesWithGenres: List<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        getGenres()
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
        api.upcomingMovies(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE, 1, TmdbApi.DEFAULT_REGION)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    moviesWithGenres = it.results.map { movie ->
                        movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
                    }
                    recyclerView.adapter = HomeAdapter(moviesWithGenres, this)
                    progressBar.visibility = View.GONE
                }
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, DetailMovieActivity::class.java)
        val movie: Movie = moviesWithGenres.get(position)
        intent.putExtra(DetailMovieActivity.MOVIE_DETAIL, movie as Serializable)
        startActivity(intent)
    }
}
