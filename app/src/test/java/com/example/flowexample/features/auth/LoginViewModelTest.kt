package com.example.flowexample.features.auth

import com.example.flowexample.features.auth.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    // Mocking the ViewModel dependencies
    private lateinit var viewModel: LoginViewModel
    val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = LoginViewModel()
    }

    @Test
    fun `email validation returns true for valid email`() {
        runTest(testDispatcher) {
            // Given a valid email
            val validEmail = "test@example.com"

            // When setting the email in the ViewModel
            viewModel.setEmail(validEmail)

            advanceUntilIdle()

            // Then the email validation should return true
            assertTrue(viewModel.isEmailValid.value)
        }
    }

    @Test
    fun `email validation returns false for invalid email`() {
        runTest(testDispatcher) {
            // Given an invalid email
            val invalidEmail = "invalidEmail"

            // When setting the email in the ViewModel
            viewModel.setEmail(invalidEmail)

            // Then the email validation should return false
            assertFalse(viewModel.isEmailValid.value)
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
            assertTrue(viewModel.isPasswordValid.value)
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
            assertFalse(viewModel.isPasswordValid.value)
        }
    }
}
