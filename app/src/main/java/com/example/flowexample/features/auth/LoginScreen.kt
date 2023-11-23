package com.example.flowexample.features.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.core.routes.AppRoutes

@Composable
fun LoginScreen(navHostController: NavController, viewModel: LoginViewModel = hiltViewModel()) {


    // Main column containing the login UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        // Header section with the "Login" title
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                color = Color.Black
            )
        }

        // Input fields for email and password
        Column(modifier = Modifier.weight(2f)) {
            OutlinedTextField(
                value = viewModel.email.collectAsStateWithLifecycle().value?:"",
                onValueChange = { viewModel.setEmail(it) },
                label = { Text("Email") },
                isError = !viewModel.isEmailValid.collectAsStateWithLifecycle().value,
                keyboardActions = KeyboardActions(
                    onNext = { /* Handle action */ }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            OutlinedTextField(
                value = viewModel.password.collectAsState().value?:"",
                onValueChange = { viewModel.setPassword(it) },
                visualTransformation = PasswordVisualTransformation(),
                label = { Text("Password") },

                isError = !viewModel.isPasswordValid.collectAsState().value,
                keyboardActions = KeyboardActions(
                    onDone = { /* Handle action */ }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            // Spacer for layout separation
            Spacer(modifier = Modifier.height(16.dp))

            // Login button
            Button(
                onClick = {
                        navHostController.navigate(AppRoutes.POST_SCREEN.routeName)

                          },
                enabled = viewModel.isEmailValid.collectAsState().value &&
                        viewModel.isPasswordValid.collectAsState().value,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(8.dp)
            ) {
                Text("Login")
            }

            // Spacer for layout separation
            Spacer(modifier = Modifier.height(16.dp))

            // Sign-up link
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Don't have an account? ")
                Text(
                    text = "Sign up",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable { /* Handle sign up click */ }
                )
            }
        }
    }
}
