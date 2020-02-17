package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

const val BASE_URL = "https://api.themoviedb.org/3/movie/popular?api_key=e5a0d41cca5009681d09bff1dd73ff03"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMovies()
    }



    private fun getMovies(){
        val request = Request.Builder().url(BASE_URL).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()

                val gson = Gson()
                val movies = gson.fromJson(body, Welcome::class.java).movies as Array<out Movie>
                
                Thread{
                    MovieRepository.get().addMovies(*movies)
                }.start()
                
                
            }
        })
    }
}