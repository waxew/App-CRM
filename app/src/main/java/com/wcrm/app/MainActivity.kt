package com.wcrm.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme

/** نقطه ورود اصلی؛ تمام پوسته عمومی از WCrmApp و AppConfig تغذیه می‌شود. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                WCrmApp()
            }
        }
    }
}
