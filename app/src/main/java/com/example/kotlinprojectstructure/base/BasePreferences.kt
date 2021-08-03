package com.example.kotlinprojectstructure.base

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

abstract class BasePreferences {

    abstract var prefs: SharedPreferences?
    abstract var editor: SharedPreferences.Editor?
    abstract fun init(context: Context)
    private val gson = Gson()

    private fun validate() {
        if (prefs == null) {
            throw PreferencesException()
        }
    }

    protected fun putString(key: String, value: String?) {
        validate()
        editor!!.putString(key, value)
        editor!!.apply()
    }


    protected fun getString(key: String, defValue: String?): String? {
        validate()
        return prefs!!.getString(key, defValue)
    }

    protected fun putInt(key: String, value: Int) {
        validate()
        editor!!.putInt(key, value)
        editor!!.apply()
    }

    protected fun getInt(key: String, defValue: Int): Int {
        validate()
        return prefs!!.getInt(key, defValue)
    }

    protected fun <T> getSerializable(key: String, jsonClass: Class<T>): T {
        validate()
        return gson.fromJson<T>(getString(key, null), jsonClass)
    }

    protected fun <T> putSerializable(key: String, value: T) {
        validate()
        putString(key, gson.toJson(value))
    }

    protected fun clearAll() {
        editor?.clear()?.apply()
    }

}