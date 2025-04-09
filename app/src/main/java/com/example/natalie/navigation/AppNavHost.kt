package com.example.natalie.navigation

import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.natalie.ui.theme.screens.SplashScreen
import com.example.natalie.ui.theme.screens.home.HomeScreen
import com.example.natalie.ui.theme.screens.login.LoginScreen
import com.example.natalie.ui.theme.screens.register.RegisterScreen
import com.example.natalie.ui.theme.screens.students.AddstudentScreen

@Composable
fun AppNavHost(navController: NavHostController= rememberNavController(),startDestination:String= ROUTE_SPLASH){
       NavHost(navController = navController, startDestination = startDestination) {
           composable(ROUTE_SPLASH){ SplashScreen {
               navController.navigate(ROUTE_REGISTER){
                   popUpTo(ROUTE_SPLASH){inclusive=true}} }}
           composable(ROUTE_REGISTER) { RegisterScreen(navController)}
           composable(ROUTE_LOGIN) { LoginScreen(navController) }
           composable(ROUTE_HOME) { HomeScreen(navController) }
           composable(ROUTE_ADD_STUDENT) { AddstudentScreen(navController) }

       }

}


