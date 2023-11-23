package com.example.core.validators

interface FieldValidator<T> {


    fun validate(value: T):Boolean
}