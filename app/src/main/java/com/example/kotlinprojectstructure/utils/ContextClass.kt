package com.example.kotlinprojectstructure.utils

import android.content.Context

abstract class ContextClass {

    companion object {

        private lateinit var context: Context

        fun setContext(con: Context) {
            context=con
        }
        fun getContext(): Context {
            return context
        }
    }
}