package com.manoj.guitarhero

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class Notification(val context:Context) {
    val CHANNEL_1: String = "Channel1"

    fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                CHANNEL_1,
                "Channel 1",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description = "This is channel 1"


            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(channel1)
        }
    }
}