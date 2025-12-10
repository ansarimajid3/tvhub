package com.example.stbemu.player

import android.content.Context
import androidx.media3.common.MediaItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

class SubtitleManager(private val ctx: Context) {
    suspend fun downloadSubtitle(urlStr: String): File? = withContext(Dispatchers.IO) {
        try {
            val url = URL(urlStr)
            val conn = url.openConnection() as HttpURLConnection
            conn.connectTimeout = 10000
            conn.readTimeout = 15000
            val outFile = File(ctx.cacheDir, "sub_${System.currentTimeMillis()}.srt")
            conn.inputStream.use { input -> outFile.outputStream().use { output -> input.copyTo(output) } }
            outFile
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun convertSrtToVtt(srt: File): File {
        val vttFile = File(ctx.cacheDir, srt.nameWithoutExtension + ".vtt")
        vttFile.writeText("WEBVTT\n\n" + srt.readText().replace(',', '.'))
        return vttFile
    }
}
