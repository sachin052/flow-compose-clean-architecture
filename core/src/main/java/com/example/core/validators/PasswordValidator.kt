package com.example.core.validators

// Password validation class
class PasswordValidator : FieldValidator<String> {
    override fun validate(value: String): Boolean {
        return value.length >= 6
    }
}