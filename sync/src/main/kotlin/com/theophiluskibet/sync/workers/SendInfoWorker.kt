/**
 * MIT License
 *
 * Copyright (c) 2024 Kibet Theo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
