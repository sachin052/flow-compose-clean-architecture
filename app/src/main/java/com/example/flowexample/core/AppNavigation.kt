package com.example.flowexample.core

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flowexample.core.routes.AppRoutes
import com.example.flowexample.features.auth.LoginScreen
import com.example.flowexample.features.posts.presentation.PostScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.LOGIN.routeName
    ) {
        composable(AppRoutes.LOGIN.routeName) {
            // Composable for the home screen
            LoginScreen(navController)
        }
        composable(AppRoutes.POST_SCREEN.routeName) {
            PostScreen(navController)
        }
    }
}
