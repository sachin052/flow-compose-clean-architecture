package com.example.flowexample.features.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class LoginViewModel : ViewModel() {
    // Input fields
    private val _email = MutableStateFlow<String?>(null)
    private val _password = MutableStateFlow<String?>(null)
    // Validation results
    private val _isEmailValid = MutableStateFlow(false)
    private val _isPasswordValid = MutableStateFlow(false)

    // Expose the StateFlows as immutable StateFlow to the UI
    val email: StateFlow<String?> = _email.asStateFlow()
    val password: StateFlow<String?> = _password.asStateFlow()
    val isEmailValid: StateFlow<Boolean> = _isEmailValid
    val isPasswordValid: StateFlow<Boolean> = _isPasswordValid

    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9+._%\\-]{1,256}" +
                "@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    init {
        // Define your validation logic here
        viewModelScope.launch {
            _email.collect { email ->
                _isEmailValid.value = email?.let { isValidEmail(it) } == true
            }
        }
        viewModelScope.launch {
            _password.collect { password ->
                _isPasswordValid.value = password?.let { isValidPassword(it) } == true
            }
        }
    }

    // Validation functions
    private fun isValidEmail(email: String): Boolean {

        // Implement your email validation logic here (e.g., regex)
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        // Implement your password validation logic here (e.g., length check)
        return password.length >= 6
    }

    // Function to update email and password fields
    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }
}
