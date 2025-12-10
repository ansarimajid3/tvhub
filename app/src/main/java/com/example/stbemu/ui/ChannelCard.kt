package com.example.stbemu.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChannelCard(title: String) {
    ElevatedCard(modifier = Modifier.size(320.dp, 180.dp)) {
        Text(title)
    }
}
