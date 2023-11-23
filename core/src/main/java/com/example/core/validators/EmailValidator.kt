package com.example.core.validators

// Email validation class
class EmailValidator : FieldValidator<String> {
    override fun validate(value: String): Boolean {
        // Implement your email validation logic here
        // Return true if the email is valid, false otherwise
        return android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}