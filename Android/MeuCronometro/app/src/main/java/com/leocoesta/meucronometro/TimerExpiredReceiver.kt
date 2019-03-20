package com.leocoesta.meucronometro

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.leocoesta.meucronometro.util.NotificationUtil
import com.leocoesta.meucronometro.util.PrefUtil

class TimerExpiredReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        NotificationUtil.showTimerExpired(context)

        PrefUtil.setTimerState(MainActivity.TimerState.STOPPED, context)
        PrefUtil.setAlarmSetTimer(0, context)
    }
}
