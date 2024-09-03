package com.theophiluskibet.sync.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkerParameters
import com.theophiluskibet.domain.repos.CharactersRepository
import org.koin.android.annotation.KoinWorker
import org.koin.core.annotation.InjectedParam
import java.util.concurrent.TimeUnit

@KoinWorker
class SendInfoWorker(
    private val charactersRepository: CharactersRepository,
    context: Context,
    @InjectedParam workerParameters: WorkerParameters,
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        return try {
            val result = charactersRepository.getCharacters()
            Log.d("WORKER", "Here we go: $result")
            Result.success()
        } catch (exception: Exception) {
            Result.failure()
        }
    }
}

val sendInfoWorkRequest =
    PeriodicWorkRequestBuilder<SendInfoWorker>(15, TimeUnit.MINUTES)
        .build()
