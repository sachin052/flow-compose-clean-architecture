package com.example.flowexample.core.validators

interface FieldValidator<T> {


    fun validate(value: T):Boolean
}