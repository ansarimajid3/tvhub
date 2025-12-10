package com.example.stbemu

import android.net.Uri
import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.stbemu.player.SubtitleManager

class PlayerActivity : ComponentActivity() {
    private var player: ExoPlayer? = null
    private lateinit var playerView: PlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        playerView = PlayerView(this)
        playerView.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        setContentView(playerView)

        val url = intent.getStringExtra("url") ?: return
        initializePlayer(url)
    }

    private fun initializePlayer(url: String) {
        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        val mediaItem = MediaItem.Builder().setUri(Uri.parse(url)).build()
        player?.setMediaItem(mediaItem)

        // Example subtitle support placeholder (actual download/use from SubtitleManager)
        val subMgr = SubtitleManager(this)
        // TODO: download & attach subtitles here

        player?.prepare()
        player?.play()
    }

    override fun onStop() {
        super.onStop()
        player?.release()
        player = null
    }
}
