package com.example.movieapp

import android.app.Application


//This class initialize the database when the app first run
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        MovieRepository.initialize(this )
    }
}