package dev.petronilio.githubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Visibility
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.petronilio.githubapp.api.GithubService
import dev.petronilio.githubapp.model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.facebook.stetho.okhttp3.StethoInterceptor
import kotlinx.android.synthetic.main.include_loading.*
import okhttp3.OkHttpClient



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSearchUser.setOnClickListener {
            showLoading()

            var client = OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(client)
                .addConverterFactory( GsonConverterFactory.create() )
                .build()

            val service = retrofit.create<GithubService>(GithubService::class.java)


        }
    }
    private fun showLoading(){
        containerLoading.visibility = View.VISIBLE
    }
    private fun hideLoading(){
        containerLoading.visibility = View.GONE
    }
}
