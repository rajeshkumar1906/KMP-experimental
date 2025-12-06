package com.example.kmp_sample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import  kotlinx.coroutines.IO

actual open class BaseViewModel {
    actual val scope : CoroutineScope = CoroutineScope(Dispatchers.IO)
}