package com.example.core.validators

// Password validation class
class PasswordValidator : FieldValidator<String> {
    override fun validate(value: String): Boolean {
        // Implement your password validation logic here
        // For example, check if the password meets certain criteria
        return value.length >= 6
    }
}