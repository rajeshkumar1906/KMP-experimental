package com.example.kmp_sample

expect  class  Platform {
    val osName: String
    val osVersion: String
    val deviceModel: String
    val density: String

    fun logSystemInfo()
}