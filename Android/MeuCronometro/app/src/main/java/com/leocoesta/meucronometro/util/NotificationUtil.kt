package com.leocoesta.meucronometro.util

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import androidx.core.app.NotificationCompat
import com.leocoesta.meucronometro.AppConstants
import com.leocoesta.meucronometro.R
import com.leocoesta.meucronometro.TimerNotificationActionReceiver

class NotificationUtil {
    companion object {
        private const val CHANNEL_ID_TIMER = "menu_timer"
        private const val CHANNEL_NAME_TIMER = "Timer App Timer"
        private const val TIMER_ID = 0

        fun showTimerExpired(context: Context) {
            val startIntent = Intent(context, TimerNotificationActionReceiver::class.java)
            startIntent.action = AppConstants.ACTION_START
            val startPendingIntent = PendingIntent.getBroadcast(context, 0,
                startIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            
            val notificationBuilder = getBasicNotificationBuilder(context, CHANNEL_ID_TIMER, true)
            notificationBuilder.setContentTitle("Timer Expired!")
                .setContentText("Start Again?")
                .setContentIntent()
        }

        private fun getBasicNotificationBuilder(context: Context, channelId: String, playSound: Boolean): NotificationCompat.Builder {
            val notificationSound: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val nBuilder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_timer)
                .setAutoCancel(true)
                .setDefaults(0)

            if (playSound)
                nBuilder.setSound(notificationSound)

            return nBuilder
        }

        private fun <T> getPendingIntentWithStack(context: Context, javaClass: Class<T>): PendingIntent {

        }
    }
}