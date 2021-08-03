package com.example.kotlinprojectstructure.utils.extentions

import android.util.Log
import java.util.*

fun calculateAgeFromDateOfBirth(dob1: String):Int{
    val dob=dob1.split("-")

    val dob2 = Calendar.getInstance()
    val today = Calendar.getInstance()
    dob2.set(dob[0].toInt(),dob[1].toInt(),dob[2].toInt())

    var age = today[Calendar.YEAR] - dob2[Calendar.YEAR]
    if (((today[Calendar.MONTH]+1) < dob2[Calendar.MONTH]) || (today[Calendar.DAY_OF_MONTH] < dob2[Calendar.DAY_OF_MONTH])) {
        age--
    }
Log.i("Age",age.toString())
    return age
}//calculateAgeFromDateOfBirth