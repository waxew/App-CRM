package com.wcrm.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * نقطه ورود اصلی برنامه W-CRM.
 * این Activity در نسخه‌های بعدی میزبان Navigation Compose و Runtime Bootstrap خواهد بود.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                WCrmRoot()
            }
        }
    }
}

/**
 * صفحه موقت ریشه برنامه تا زمان اتصال کامل Dashboard و Navigation.
 */
@Composable
private fun WCrmRoot() {
    Text(text = "W-CRM")
}
