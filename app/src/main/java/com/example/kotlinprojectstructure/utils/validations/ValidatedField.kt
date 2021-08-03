package com.example.kotlinprojectstructure.utils.validations

import android.widget.EditText

interface OnValidateField {
    fun pass(editText: EditText)
    fun failed(editText: EditText, error: String)
}

class ValidatedField(val editText: EditText, val rulesList: List<Rule>) {
    fun validate(onValidateField: OnValidateField) {
        for (rule in rulesList) {
            rule.isValid(object : OnRuleValid {
                override fun success() {
                    onValidateField.pass(editText)
                }
                override fun failed(error: String) {
                    onValidateField.failed(editText, error)
                    return
                }

            })
        }
    }
}
