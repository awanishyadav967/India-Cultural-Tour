package India.Cultural.Tour.Utils

import android.content.Context
import android.media.MediaPlayer
import India.Cultural.Tour.R

class PlayMusic {
    var mMediaPlayer: MediaPlayer? = null

    fun SoundNotification(context: Context?) {
        mMediaPlayer = MediaPlayer.create(context, R.raw.soundialog)
        mMediaPlayer!!.start()
    }

}