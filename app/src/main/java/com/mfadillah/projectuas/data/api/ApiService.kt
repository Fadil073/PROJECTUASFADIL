package com.mfadillah.projectuas.data.api

import com.mfadillah.projectuas.data.model.ListResponse
import com.mfadillah.projectuas.data.model.MovieResponse
import com.mfadillah.projectuas.data.model.TvShowResponse
import com.mfadillah.projectuas.utils.API_KEY
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("movie/now_playing?api_key=$API_KEY")
    fun getMovies(): Call<ListResponse<MovieResponse>>

    @GET("tv/airing_today?api_key=$API_KEY")
    fun getTvShow(): Call<ListResponse<TvShowResponse>>

}