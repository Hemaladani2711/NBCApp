package com.hemaladani.nbcapp.di

import com.hemaladani.nbcapp.ui.home.HomeRepository
import com.hemaladani.nbcapp.ui.home.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun providesDataRepository(homeRepositoryImpl: HomeRepositoryImpl):HomeRepository
}