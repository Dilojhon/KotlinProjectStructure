package com.example.kotlinprojectstructure.utils.validations

import android.widget.EditText
import com.example.kotlinprojectstructure.utils.extentions.getString

abstract class FormValidation {

    abstract fun validate(onFormValidationListener: OnFormValidationListener)
    fun applyValidation(
        list: List<ValidatedField>,
        onFormValidationListener: OnFormValidationListener
    ) {
        var pass = false
        var error1 = ""
        var editText1: EditText? = null
        val listener = object : OnValidateField {

            override fun pass(editText: EditText) {
                pass = true
            }

            override fun failed(editText: EditText, error: String) {
                pass = false
                error1 = error
                editText1 = editText
            }
        }
        for (field in list) {
            field.validate(listener)
            if (pass.not()) {
                break
            }
        }
        if (pass) {
            onFormValidationListener.onValidated()
        } else {
            onFormValidationListener.onNotValidated(editText1!!, error1)
        }
    }
}

//////////////////////////////////////////////////////

class PasswordFormValidation(private val etPassword: EditText) :
    FormValidation() {
    override fun validate(onFormValidationListener: OnFormValidationListener) {
        val list = listOf(ValidatedField(etPassword, listOf(PasswordRule(etPassword.getString()))))
        applyValidation(list, onFormValidationListener)
    }
}

class SignupFormValidation(private val etEmail: EditText, private val etPassword: EditText) :
    FormValidation() {
    override fun validate(onFormValidationListener: OnFormValidationListener) {
        val list = listOf(
            ValidatedField(etEmail, listOf(EmailRule(etEmail.getString()))),
            ValidatedField(etPassword, listOf(PasswordRule(etPassword.getString())))
        )
        applyValidation(list, onFormValidationListener)
    }
}

class LoginFormValidation(private val etEmail: EditText, private val etPassword: EditText) :
    FormValidation() {
    override fun validate(onFormValidationListener: OnFormValidationListener) {
        val list = listOf(
            ValidatedField(etEmail, listOf(EmailRule(etEmail.getString()))),
            ValidatedField(etPassword, listOf(NotEmptyRule(etPassword.getString())))
        )
        applyValidation(list, onFormValidationListener)
    }
}

class ResetPasswordFormValidation(
    private val etPassword: EditText,
    private val etConfirmPassword: EditText
) :
    FormValidation() {
    override fun validate(onFormValidationListener: OnFormValidationListener) {
        val list = listOf(
            ValidatedField(etPassword, listOf(PasswordRule(etPassword.getString()))),
            ValidatedField(etConfirmPassword, listOf(PasswordRule(etConfirmPassword.getString()))),
            ValidatedField(etConfirmPassword, listOf(SignUpConfirmPassword(etConfirmPassword.getString(), etConfirmPassword.getString())))
        )
        applyValidation(list, onFormValidationListener)
    }
}










