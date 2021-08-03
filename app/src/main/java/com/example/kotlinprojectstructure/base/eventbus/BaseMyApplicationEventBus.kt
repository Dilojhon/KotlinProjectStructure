package com.example.kotlinprojectstructure.base.eventbus

import org.greenrobot.eventbus.EventBus

object BaseMyApplicationEventBus {
    val eventBus: EventBus = EventBus.getDefault()
}
