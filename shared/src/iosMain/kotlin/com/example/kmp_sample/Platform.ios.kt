package com.example.kmp_sample

import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import platform.Foundation.NSLog

 actual class Platform   {
    actual val osName: String = UIDevice.currentDevice.systemName()
    actual val osVersion: String = UIDevice.currentDevice.systemVersion
    actual val deviceModel: String = UIDevice.currentDevice.model
    actual val density: String = UIScreen.mainScreen.scale.toInt().toString()

    actual fun logSystemInfo(){
        NSLog("$osName, $osVersion, $deviceModel, $density")
    }
}