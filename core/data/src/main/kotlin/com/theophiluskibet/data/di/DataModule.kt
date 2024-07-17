package com.theophiluskibet.data.di

import com.theophiluskibet.remote.di.RemoteModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(includes = [RemoteModule::class])
@ComponentScan("com.theophiluskibet.data")
class DataModule {

}