package com.example.kotlinprojectstructure.base.eventbus


interface BaseEventBus {

    fun register(subscriber: Any) {
        if (BaseMyApplicationEventBus.eventBus.isRegistered(subscriber).not())
            BaseMyApplicationEventBus.eventBus.register(subscriber)
    }

    fun unRegister(subscriber: Any) {
        BaseMyApplicationEventBus.eventBus.unregister(subscriber)
    }

    fun postEvent(messageEvent: Any?) {
        BaseMyApplicationEventBus.eventBus.post(messageEvent)
    }

    fun postStickyEvent(messageEvent: Any?) {
        BaseMyApplicationEventBus.eventBus.postSticky(messageEvent)
    }

    fun <T> getStickyEvent(messageEvent: Class<T>): T {
        return BaseMyApplicationEventBus.eventBus.getStickyEvent(messageEvent)
    }

    fun <T> consumeStickyEvent(messageEvent: Class<T>): T {
        return BaseMyApplicationEventBus.eventBus.removeStickyEvent(messageEvent)
    }

    fun removeStickyEvent(messageEvent: Any?) {
        BaseMyApplicationEventBus.eventBus.removeStickyEvent(messageEvent)
    }

    fun removeAllStickyEvent() {
        BaseMyApplicationEventBus.eventBus.removeAllStickyEvents()
    }
}