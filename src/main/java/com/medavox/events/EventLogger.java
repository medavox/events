package com.medavox.events;

import android.util.Log;

import com.medavox.events.Event;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author Adam Howard
on 22/07/2016
 * Listens for all events extending the Event class, and prints them to the Android Log.
 */
public class EventLogger {
    public EventLogger()
    {
        EventBus.getDefault().register(this);
    }

    @Subscribe (threadMode = ThreadMode.BACKGROUND)
    public void logEvent(Event e) {
        Log.d("Event_Logger", "Event received ["+e+"] ");
    }
}
