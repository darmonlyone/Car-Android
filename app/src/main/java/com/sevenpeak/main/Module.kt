package com.sevenpeak.main;

import com.sevenpeak.main.data.database.local.CarsLocal
import com.sevenpeak.main.data.database.local.CarsLocalImpl
import com.sevenpeak.main.data.datasource.CarsDataSource
import com.sevenpeak.main.data.datasource.CarsDataSourceImpl
import com.sevenpeak.main.data.network.remote.CarsRemote
import com.sevenpeak.main.data.network.remote.CarsRemoteImpl
import com.sevenpeak.main.domain.repository.GetCarsRepository
import com.sevenpeak.main.domain.repository.GetCarsRepositoryImpl
import com.sevenpeak.main.domain.usecase.GetCarsUseCase
import com.sevenpeak.main.ui.viewmodels.CarsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    single<CarsRemote> { CarsRemoteImpl() }
    single<CarsLocal> { CarsLocalImpl() }
    single<CarsDataSource> { CarsDataSourceImpl(get(), get()) }
    single<GetCarsRepository> { GetCarsRepositoryImpl(get()) }
    single { GetCarsUseCase(get()) }
    viewModel { CarsViewModel(get()) }
}