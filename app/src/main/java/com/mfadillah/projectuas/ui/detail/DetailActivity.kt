package com.mfadillah.projectuas.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mfadillah.projectuas.data.model.MovieResponse
import com.mfadillah.projectuas.data.model.TvShowResponse
import com.mfadillah.projectuas.databinding.ActivityDetailBinding
import com.mfadillah.projectuas.utils.BASE_URL_API_IMAGE
import com.mfadillah.projectuas.utils.POSTER_SIZE_W185
import com.mfadillah.projectuas.utils.POSTER_SIZE_W780
import com.mfadillah.projectuas.utils.loadImageMovie
import com.mfadillah.projectuas.utils.loadImageTvShow

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataIntent()
    }

    private fun getDataIntent() {
        val type = intent?.extras?.getString(EXTRA_TYPE)

        if (type == data[0]){
            val data = intent?.extras?.getParcelable<MovieResponse>(EXTRA_DATA)
            getDetailMovie(data as MovieResponse)
        }else{
            val data = intent?.extras?.getParcelable<TvShowResponse>(EXTRA_DATA)
            getDetailTvShow(data as TvShowResponse)
        }
    }

    private fun getDetailTvShow(data: TvShowResponse) {
        binding.apply {
            imgDetailPoster.loadImageTvShow("$BASE_URL_API_IMAGE$POSTER_SIZE_W185${data.imgPreview}")
            imgDetailHightlight.loadImageTvShow("$BASE_URL_API_IMAGE$POSTER_SIZE_W780${data.poster}")
            tvTitle.text = data.name
            tvDesc.text = data.desc
            tvReleaseDate.text = data.releaseDate
        }
    }

    private fun getDetailMovie(data: MovieResponse) {
        binding.apply {
            imgDetailPoster.loadImageMovie("$BASE_URL_API_IMAGE$POSTER_SIZE_W780${data.poster}")
            imgDetailHightlight.loadImageMovie("$BASE_URL_API_IMAGE$POSTER_SIZE_W185${data.imgPreview}")
            tvTitle.text = data.name
            tvDesc.text = data.desc
            tvReleaseDate.text = data.releaseDate
        }
    }

    companion object{
        val data = arrayOf("movie", "tvshow")
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "type"
    }
}