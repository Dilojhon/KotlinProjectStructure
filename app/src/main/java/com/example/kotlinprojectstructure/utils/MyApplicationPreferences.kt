package com.example.kotlinprojectstructure.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.kotlinprojectstructure.base.BasePreferences

object MyApplicationPreferences : BasePreferences() {

    private val keys = Constants.Prefs

    override var prefs: SharedPreferences? = null
    override var editor: SharedPreferences.Editor? = null

    override fun init(context: Context) {
        prefs = context.getSharedPreferences(
            Constants.Prefs.KEY,
            Context.MODE_PRIVATE
        ) as SharedPreferences
        editor = prefs!!.edit()
    }

   var token
        get() = getString(keys.TOKEN, null)
        set(value) = putString(keys.TOKEN, value)

    var fcmtoken
        get() = getString(keys.FCMTOKEN, null)
        set(value) = putString(keys.FCMTOKEN, value)

    var role
        get() = getString(keys.ROLE,null)
        set(value) = putString(keys.ROLE,value)


    fun expireUserSession() {
        clearAll()
    }
}