package com.example.jetpackcompose_retrofitpromoapp.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    fun provideApi(builder: Retrofit.Builder):CharacterAPI{
        return builder.build().create(CharacterAPI::class.java)
    }

    fun provideRetrofit(): Retrofit.Builder{
         val moshi =
            Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
        return Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://hp-api.onrender.com/api/")
    }
}