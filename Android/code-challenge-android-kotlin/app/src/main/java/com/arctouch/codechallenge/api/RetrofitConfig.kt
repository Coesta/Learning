package com.arctouch.codechallenge.api

import com.arctouch.codechallenge.data.Cache
import com.arctouch.codechallenge.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitConfig {

    companion object {
        val api: TmdbApi = Retrofit.Builder()
                .baseUrl(TmdbApi.URL)
                .client(OkHttpClient.Builder().build())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(TmdbApi::class.java)

        var moviesWithGenres: MutableList<Movie> = emptyList<Movie>().toMutableList()

        fun getUpcomingMovies(apiKey: String, defaultLanguage: String, page: Long, defaultRegion: String):MutableList<Movie> {

            api.upcomingMovies(apiKey, defaultLanguage, page, defaultRegion)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        moviesWithGenres =  it.results.map { movie ->
                            movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
                        }.toMutableList()
                    }

            return moviesWithGenres
        }
    }
}