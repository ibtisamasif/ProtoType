package com.example.androidprototype.core

import com.example.androidprototype.repos.MainRepo
import com.example.androidprototype.viewmodels.DataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModules = module {
    single { PrototypePrefManager(get()) }
    single { MainRepo(get()) }
    viewModel { DataViewModel(get()) }
}