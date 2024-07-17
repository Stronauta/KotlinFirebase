package com.example.firabaseprueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.work.BackoffPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.firabaseprueba.ui.theme.FirabasePruebaTheme
import com.example.firabaseprueba.workmanager.CustomWorker
import java.time.Duration
import java.util.concurrent.TimeUnit

@OptIn(kotlin.time.ExperimentalTime::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirabasePruebaTheme {
                LaunchedEffect(key1 = Unit) {
                    val request = PeriodicWorkRequestBuilder<CustomWorker>(
                        repeatInterval = 15,
                        repeatIntervalTimeUnit = TimeUnit.SECONDS
                    )
                        .setBackoffCriteria(
                            backoffPolicy = BackoffPolicy.LINEAR,
                            duration = Duration.ofSeconds(15)
                        )
                        .build()

                    WorkManager
                        .getInstance(applicationContext)
                        .enqueue(request)
                }
            }
        }
    }
}

