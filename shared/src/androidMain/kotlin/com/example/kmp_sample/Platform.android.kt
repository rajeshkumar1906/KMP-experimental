package com.example.kmp_sample

import android.util.Log

actual class Platform{
    actual val osName: String = "Android"
    actual val osVersion: String = "12"
    actual val deviceModel: String = "Nexus 5"
    actual val density: String = "480"

    actual fun logSystemInfo(){
        Log.e("TAG", "$osName, $osVersion, $deviceModel, $density")
    }
}