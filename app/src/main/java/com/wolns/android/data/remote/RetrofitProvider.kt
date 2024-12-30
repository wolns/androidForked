package com.wolns.android.data.remote

import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Single
fun provideRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://wolns.fadegor05.ru/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()