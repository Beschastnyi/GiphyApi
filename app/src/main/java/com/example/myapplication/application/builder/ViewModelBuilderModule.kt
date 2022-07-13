package com.example.myapplication.application.builder

import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelBuilderModule {
    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}