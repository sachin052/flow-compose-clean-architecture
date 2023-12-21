package com.example.auth

import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.core.dimens.Dimens
import com.example.core.routes.AppRoutes

@Composable
fun LoginScreen(navHostController: NavController, viewModel: LoginViewModel = hiltViewModel()) {


    // Main column containing the login UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.spacingLarge)
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        // Header section with the "Login" title
        Column(
            modifier = Modifier.weight(Dimens.weight1F),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.login),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.spacingMedium),
                color = Color.Black
            )
        }

        // Input fields for email and password
        Column(modifier = Modifier.weight(Dimens.weight2F)) {
            OutlinedTextField(
                value = viewModel.email.collectAsStateWithLifecycle().value ?: "",
                onValueChange = { viewModel.setEmail(it) },
                label = { Text(stringResource(R.string.email)) },
                isError = !viewModel.isEmailValid.collectAsStateWithLifecycle().value,
                keyboardActions = KeyboardActions(
                    onNext = { }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.spacingMedium)
            )

            OutlinedTextField(
                value = viewModel.password.collectAsStateWithLifecycle().value ?: "",
                onValueChange = { viewModel.setPassword(it) },
                visualTransformation = PasswordVisualTransformation(),
                label = { Text(stringResource(R.string.password)) },

                isError = !viewModel.isPasswordValid.collectAsStateWithLifecycle().value,
                keyboardActions = KeyboardActions(
                    onDone = {
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.spacingMedium)
            )

            // Spacer for layout separation
            Spacer(modifier = Modifier.height(Dimens.spacingLarge))

            // Login button
            Button(
                onClick = {
                    navHostController.navigate(AppRoutes.POST_SCREEN.routeName)

                },
                enabled = viewModel.isEmailValid.collectAsStateWithLifecycle().value &&
                        viewModel.isPasswordValid.collectAsStateWithLifecycle().value,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.dimens50Dp)
                    .padding(Dimens.spacingMedium)
            ) {
                Text(stringResource(id = R.string.login))
            }

            // Spacer for layout separation
            Spacer(modifier = Modifier.height(Dimens.spacingLarge))

            // Sign-up link
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(stringResource(R.string.don_t_have_an_account))
                Text(
                    text = stringResource(R.string.sign_up),
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}
