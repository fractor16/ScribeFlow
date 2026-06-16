package com.piyush.scribeflow.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.piyush.scribeflow.presentation.appointment.AppointmentScreen
import com.piyush.scribeflow.presentation.auth.LoginScreen
import com.piyush.scribeflow.presentation.dashboard.DashboardScreen

@Composable
fun MediScribeNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoute.Login.route
    ) {

        composable(
            route = AppRoute.Login.route
        ) {

            LoginScreen(
                onLoginSuccess = {

                    navController.navigate(
                        AppRoute.Dashboard.route
                    ) {
                        popUpTo(
                            AppRoute.Login.route
                        ) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(
            route = AppRoute.Dashboard.route
        ) {
            DashboardScreen(
                onCreateAppointment = {
                    navController.navigate(
                        AppRoute.Appointment.route
                    )
                }
            )
        }


        composable(
            route = AppRoute.Appointment.route
        ) {
            AppointmentScreen()
        }
    }
}