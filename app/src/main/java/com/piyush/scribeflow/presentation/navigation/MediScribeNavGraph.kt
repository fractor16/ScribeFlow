package com.piyush.scribeflow.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.piyush.scribeflow.presentation.appointment.AppointmentScreen
import com.piyush.scribeflow.presentation.auth.LoginScreen
import com.piyush.scribeflow.presentation.dashboard.DashboardScreen
import com.piyush.scribeflow.presentation.recording.RecordingHistoryScreen
import com.piyush.scribeflow.presentation.recording.RecordingScreen

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
                },

                onStartRecording = {
                    navController.navigate(
                        AppRoute.Recording.route
                    )
                }
            )
        }


        composable(
            route = AppRoute.Appointment.route
        ) {
            AppointmentScreen()
        }

        composable(
            route = AppRoute.Recording.route
        ) {
            RecordingScreen(
                onOpenHistory = {
                    navController.navigate(
                        AppRoute.RecordingHistory.route
                    )
                }
            )
        }

        composable(
            route = AppRoute.RecordingHistory.route
        ) {
            RecordingHistoryScreen()
        }
    }
}