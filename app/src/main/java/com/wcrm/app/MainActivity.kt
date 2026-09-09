package com.wcrm.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.wcrm.feature.dashboard.DashboardScreen

/**
 * نقطه ورود اصلی برنامه W-CRM.
 *
 * Activity فقط میزبان Compose است و منطق کسب‌وکار در Feature/Core نگه داشته می‌شود.
 * با تکمیل Navigation، مقصدهای دیگر از همین لایه ثبت و مدیریت خواهند شد.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                DashboardScreen()
            }
        }
    }
}
