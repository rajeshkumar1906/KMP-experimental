package com.example.kmp_sample.android

import android.widget.Toolbar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.unit.dp
import com.example.kmp_sample.Platform

@Composable
fun AboutScreen() {
    Column {
        Toolbar()
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text("My App") },
    )
}

@Composable
fun ContentView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {
        val platform = Platform()
        Text(platform.osName)
        Text(platform.osVersion)
        Text(platform.deviceModel)
//        Text()
    }
}