package com.wolns.android.data.remote

import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Single
fun provideRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://wolns.fadegor05.ru/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()