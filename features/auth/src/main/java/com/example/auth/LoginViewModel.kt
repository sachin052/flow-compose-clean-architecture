package com.example.auth

import androidx.lifecycle.viewModelScope
import com.example.core.validators.EmailValidator
import com.example.core.validators.PasswordValidator
import com.example.core.viewmodel.CoreViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : CoreViewModel() {

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



    init {
        // Define your validation logic here
        viewModelScope.launch {
            _email.collect { email ->
                _isEmailValid.value = email?.let { EmailValidator().validate(it) } == true
            }
        }
        viewModelScope.launch {
            _password.collect { password ->
                _isPasswordValid.value = password?.let { PasswordValidator().validate(it) } == true
            }
        }
    }

    // Function to update email and password fields
    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }
}
