package com.example.cleancode.di

import com.example.cleancode.common.Constants
import com.example.cleancode.data.remote.TypiCodeApi
import com.example.cleancode.data.repository.UserRepositoryImpl
import com.example.cleancode.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTypiCodeApi(): TypiCodeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TypiCodeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: TypiCodeApi): UserRepository {
        return UserRepositoryImpl(api)
    }
}