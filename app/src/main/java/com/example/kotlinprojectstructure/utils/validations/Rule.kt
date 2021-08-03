package com.example.kotlinprojectstructure.utils.validations

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.kotlinprojectstructure.utils.ContextClass
import com.example.kotlinprojectstructure.utils.extentions.calculateAgeFromDateOfBirth
import java.util.regex.Matcher
import java.util.regex.Pattern

interface OnRuleValid {
    fun success()
    fun failed(error: String)
}

abstract class Rule {
    abstract fun isValid(onRuleValid: OnRuleValid)
}

class NotEmptyRule(val string: String) : Rule() {

    override fun isValid(onRuleValid: OnRuleValid) {
        if (TextUtils.isEmpty(string)) {
            onRuleValid.failed("Field should not be empty!")
        } else {
            onRuleValid.success()
        }
    }
}

class AgeRule(val string: String) : Rule() {

    // val age = calculateAgeFromDateOfBirth(string)
    var age = -1

    override fun isValid(onRuleValid: OnRuleValid) {
        if (TextUtils.isEmpty(string)) {
            onRuleValid.failed("Field should not be empty!")
        } else if (!TextUtils.isEmpty(string)) {
            age = calculateAgeFromDateOfBirth(string)
            // onRuleValid.failed("Age should not be less than 21 Years!")
            if (age < 21) {
                onRuleValid.failed("Age should not be less than 21 Years!")
                Log.i("Error", age.toString())
                Toast.makeText(
                    ContextClass.getContext(),
                    "Age should not be less than 21 Years!",
                    Toast.LENGTH_SHORT
                ).show()

            }
        } else {
            onRuleValid.success()
        }
    }
}

/*else if(age<21){
    onRuleValid.failed("Age should not be less than 21 Years!")
}*/
class NotZeroRule(val int: Int) : Rule() {
    override fun isValid(onRuleValid: OnRuleValid) {
        if (int == 0) {
            onRuleValid.failed("Field should not be empty!")
        } else {
            onRuleValid.success()
        }
    }
}

class PasswordRule(val string: String) : Rule() {
    override fun isValid(onRuleValid: OnRuleValid) {
        val numberPattern: Pattern
        val lowerCasePattern: Pattern
        val upperCasePattern: Pattern
        val numberPatterenRegex = "^[0-9]{1,40}\$"
        val lowerCasePatterenRegex = "^[a-z]{1,40}\$"
        val upperCasePatterenRegex = "^[A-Z]{1,40}\$"
        numberPattern = Pattern.compile(numberPatterenRegex)
        lowerCasePattern = Pattern.compile(lowerCasePatterenRegex)
        upperCasePattern = Pattern.compile(upperCasePatterenRegex)
        val numberMatcher: Matcher = numberPattern.matcher(string)
        val upperCaseMatcher: Matcher = upperCasePattern.matcher(string)
        val lowerCaseMatcher: Matcher = lowerCasePattern.matcher(string)
        when {
            TextUtils.isEmpty(string) -> {
                onRuleValid.failed("Field should not be empty !")
            }
            numberMatcher.matches() -> {
                onRuleValid.failed("Password should not contain all digits !")
            }
            upperCaseMatcher.matches() -> {
                onRuleValid.failed("Password should not contain all uppercase letters !")
            }
            lowerCaseMatcher.matches() -> {
                onRuleValid.failed("Password should not contain all lowercase letters !")
            }
            string.length < 8 -> {
                onRuleValid.failed("Password should be at least 8 character !")
            }
            else -> {
                onRuleValid.success()
            }
        }
    }
}

class EmailRule(private val email: String) : Rule() {
    override fun isValid(onRuleValid: OnRuleValid) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            onRuleValid.success()
        } else {
            onRuleValid.failed("Enter a valid email")
        }
    }

}

class PhoneNumberRule(private val phoneNumber: String) : Rule() {
    override fun isValid(onRuleValid: OnRuleValid) {
        if (Patterns.PHONE.matcher(phoneNumber).matches()) {
            onRuleValid.success()
        } else {
            onRuleValid.failed("Enter valid phone number")
        }
    }
}

class SignUpConfirmPassword(private val password: String, private val confirmPassword: String) :
    Rule() {
    override fun isValid(onRuleValid: OnRuleValid) {
        if (confirmPassword == password) {
            onRuleValid.success()
        } else {
            onRuleValid.failed("Password doesn't Matched")
        }
    }
}