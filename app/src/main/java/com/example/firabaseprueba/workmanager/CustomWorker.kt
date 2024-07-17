package com.example.firabaseprueba.workmanager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class CustomWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {
        override suspend fun doWork(): Result {
            delay(4_000)
            Log.d("CustomWorker", "Performing custom task...")
            return Result.success()
        }
}