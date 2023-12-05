package com.example.core.validators


class EmailValidator : FieldValidator<String> {
    override fun validate(value: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$")
        return emailRegex.matches(value)
    }
}