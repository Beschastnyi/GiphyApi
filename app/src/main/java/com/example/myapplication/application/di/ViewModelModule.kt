package com.example.myapplication.application.di

import androidx.lifecycle.ViewModel
import com.example.myapplication.application.builder.ViewModelBuilderModule
import com.example.myapplication.keys.ViewModelKey
import com.example.myapplication.mainactivity.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelBuilderModule::class])
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
