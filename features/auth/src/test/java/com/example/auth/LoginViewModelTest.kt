package com.example.auth

import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    // Mocking the ViewModel dependencies
    private lateinit var viewModel: LoginViewModel
    private val testDispatcher = StandardTestDispatcher()

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = LoginViewModel()
    }

    @ParameterizedTest
    @ValueSource(strings = ["user@example.com", "john.doe@gmail.com", "info@company.org", "alice.smith123@yahoo.co.uk", "support@website.net"])
    fun `email validation returns true for valid email`(email: String) {
        runTest(testDispatcher) {
            // Given a valid email
            val validEmail = email

            // When setting the email in the ViewModel
            viewModel.setEmail(validEmail)

            advanceUntilIdle()

            // Then the email validation should return true
            assertThat(viewModel.isEmailValid.value).isTrue()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["invalid-email", "user@missing-tld", "@missing-username.com", "spaces not@allowed.com", "special&characters@notallowed.com", "missing-at-sign.com"])
    fun `email validation returns false for invalid email`(email: String) {
        runTest(testDispatcher) {
            // Given an invalid email
            val invalidEmail = email

            // When setting the email in the ViewModel
            viewModel.setEmail(invalidEmail)

            // Then the email validation should return false
            assertThat(viewModel.isEmailValid.value).isFalse()
        }
    }

    @Test
    fun `password validation returns true for valid password`() {
        runTest(testDispatcher) {
            // Given a valid password
            val validPassword = "securePassword123"

            // When setting the password in the ViewModel
            viewModel.setPassword(validPassword)
            advanceUntilIdle()
            // Then the password validation should return true
            assertThat(viewModel.isPasswordValid.value).isTrue()
        }
    }

    @Test
    fun `password validation returns false for invalid password`() {
        runTest(testDispatcher) {
            // Given an invalid password
            val invalidPassword = "short"

            // When setting the password in the ViewModel
            viewModel.setPassword(invalidPassword)

            // Then the password validation should return false
            assertThat(viewModel.isPasswordValid.value).isFalse()
        }
    }
}
