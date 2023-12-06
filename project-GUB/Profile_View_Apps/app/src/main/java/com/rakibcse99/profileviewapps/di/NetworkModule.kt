package com.rakibcse99.profileviewapps.di

import com.rakibcse99.profileviewapps.utils.Constants
import com.rakibcse99.profileviewapps.data.source.CharacterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import com.rakibcse99.profileviewapps.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val TIME_OUT = 60L
private const val CONNECTION_TIME_OUT = 30L
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(

    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
            .protocols(listOf(Protocol.HTTP_1_1))
            .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(getLogInterceptors())
            .followRedirects(false)
            .followSslRedirects(false)
            .build()
    }

    private fun getLogInterceptors(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }
    }

    @Singleton
    @Provides
    fun providesProfileViewAPI(
        retrofitBuilder: Retrofit.Builder,
        okHttpClient: OkHttpClient
    ): CharacterApi {
        return retrofitBuilder.client(okHttpClient).build().create(CharacterApi::class.java)
    }

}