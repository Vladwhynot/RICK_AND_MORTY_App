package com.example.rickandmorty.di

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import com.example.rickandmorty.di.module.AppModule

@ExperimentalPagingApi
class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()
    }
}