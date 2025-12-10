package com.example.stbemu.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun TvHomeScreen() {
    val channels = remember { listOf("Channel 1", "Channel 2", "Channel 3") }
    Column {
        Text("Live Channels")
        LazyRow {
            items(channels) { ch ->
                ChannelCard(ch)
            }
        }
    }
}
