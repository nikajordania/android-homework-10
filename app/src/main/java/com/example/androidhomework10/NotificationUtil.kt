package com.example.androidhomework10

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

object NotificationUtil {
    private const val CHANNEL_ID = "NOTIFICATIONCHANNEL"
    fun showAirplaneModeNotification(context: Context, status: Boolean) {
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(if (status) R.drawable.ic_baseline_airplanemode_active_24 else R.drawable.ic_baseline_airplanemode_inactive_24)
            .setContentTitle("Airplane mode")
            .setContentText("Airplane mode is: ${if (status) "enabled" else "disabled"}")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = CHANNEL_ID
            val descriptionText = "AirplaneMode"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(
                name,
                descriptionText,
                importance
            ).apply {
                description = descriptionText
            }

            val manager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
            manager.notify(1, notification.build())
        }
    }
}
