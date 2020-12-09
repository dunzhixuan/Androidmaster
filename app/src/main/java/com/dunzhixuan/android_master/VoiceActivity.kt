package com.dunzhixuan.android_master

import android.content.Context
import android.database.ContentObserver
import android.media.AudioManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class VoiceActivity : AppCompatActivity(), VolumeChangeObserver.VolumeChangeListener {

    private var mVolumeChangeObserver: VolumeChangeObserver? = null
    var settingsContentObserver:SettingsContentObserver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voice)

    //实例化对象并设置监听器
    mVolumeChangeObserver = VolumeChangeObserver(this);
    mVolumeChangeObserver?.setVolumeChangeListener(this);

    mVolumeChangeObserver?.registerReceiver()

        var am: AudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        var max = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        var current = am.getStreamVolume(AudioManager.STREAM_MUSIC)
        settingsContentObserver = SettingsContentObserver(context = this, handler = Handler())
        contentResolver.registerContentObserver(android.provider.Settings.System.CONTENT_URI, true, settingsContentObserver)
    }

    class SettingsContentObserver(val context: Context, var handler: Handler?) : ContentObserver(handler) {
        var am: AudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

        override fun onChange(selfChange: Boolean) {
            super.onChange(selfChange)
            var max = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            var current = am.getStreamVolume(AudioManager.STREAM_MUSIC)
            Log.e("VoiceActivity", "CURRENT==" + current)
        }
    }

    override fun onPause() {
        super.onPause()
        contentResolver.unregisterContentObserver(settingsContentObserver)
        mVolumeChangeObserver?.unregisterReceiver()
    }

    override fun onVolumeChanged(volume: Int) {
        Log.e("VoiceActivity", "volume ==" + volume)
    }
}