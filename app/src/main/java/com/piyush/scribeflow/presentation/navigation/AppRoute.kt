sealed class AppRoute(
    val route: String
) {

    data object Login : AppRoute("login")

    data object Dashboard : AppRoute("dashboard")

    data object Appointment : AppRoute("appointment")

    data object Recording : AppRoute("recording")

    data object RecordingHistory :
        AppRoute("recording_history")
}