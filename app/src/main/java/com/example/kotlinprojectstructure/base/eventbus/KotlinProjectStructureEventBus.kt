package com.example.kotlinprojectstructure.base.eventbus


data class NameEvent(val name: String)

interface KwkBuyerEventBus : BaseEventBus {

/*    fun showLoading() {
        postEvent(LoadingBarEvent(true))
    }

    fun hideLoading() {
        postEvent(LoadingBarEvent(false))
    }

    fun showSnackBar(message: String) {
        postEvent(SnackBarEvent(message))
    }*/
}
