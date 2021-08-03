package com.example.kotlinprojectstructure.base

import com.example.kotlinprojectstructure.R

class PreferencesException :
    Exception(MyApplication.appContext.getString(R.string.str_exception_preferences))