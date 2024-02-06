package com.example.composetutorial.navigation

sealed class NavigationItem(val route: String) {
    object Splash : NavigationItem("splash_screen")
    object Home : NavigationItem("login_screen")
}