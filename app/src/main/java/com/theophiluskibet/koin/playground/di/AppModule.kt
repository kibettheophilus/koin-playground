package com.theophiluskibet.koin.playground.di

import com.theophiluskibet.data.di.DataModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(includes = [DataModule::class])
@ComponentScan("com.theophiluskibet.koin.playground")
class AppModule