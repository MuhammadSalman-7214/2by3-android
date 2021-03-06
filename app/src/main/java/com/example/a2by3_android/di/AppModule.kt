package com.example.a2by3_android.di

import com.example.a2by3_android.BuildConfig
import com.example.a2by3_android.network.NoInternetInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

  @Singleton
  @Provides
  fun provideRetrofit(gson: Gson): Retrofit {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder()
      .connectTimeout(30, TimeUnit.SECONDS)
      .writeTimeout(30, TimeUnit.SECONDS)
      .readTimeout(30, TimeUnit.SECONDS)
      .addInterceptor(interceptor)
      //.addInterceptor(BasicAuthInterceptor())
      .addInterceptor(NoInternetInterceptor())
      .build()
    return Retrofit.Builder()
      .baseUrl(BuildConfig.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .client(client)
      .build()
  }

  @Provides
  fun provideGson(): Gson = GsonBuilder().create()
}