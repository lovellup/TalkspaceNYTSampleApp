package com.lovellup.talkspacenytsampleapp.di

import com.lovellup.talkspacenytsampleapp.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainActivityViewModel(get()) }
}