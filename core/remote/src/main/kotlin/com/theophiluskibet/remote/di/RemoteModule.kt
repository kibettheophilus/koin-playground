package com.theophiluskibet.remote.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.theophiluskibet.remote")
class RemoteModule {
    @Single
    fun provideHttpEngine(): HttpClientEngine = OkHttp.create()
}
