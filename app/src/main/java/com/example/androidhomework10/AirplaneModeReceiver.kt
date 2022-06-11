package com.example.androidhomework10

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val state = intent?.getBooleanExtra("state", false) ?: return
//        Toast.makeText(context, state.toString(), Toast.LENGTH_SHORT).show()

        NotificationUtil.showAirplaneModeNotification(context!!, state)
    }
}
