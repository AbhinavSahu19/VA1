package com.example.va1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.va1.presentation.blog.BlogDestination
import com.example.va1.presentation.blog.BlogScreen
import com.example.va1.presentation.home.HomeDestination
import com.example.va1.presentation.home.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route
    ) {
        composable(HomeDestination.route) {
            HomeScreen(
                navigateToBlog = { navController.navigate("${BlogDestination.route}/$it") }
            )
        }
        composable(
            BlogDestination.routeWithArgs,
            arguments = listOf(navArgument(BlogDestination.blogIdArgs) { type = NavType.IntType })
        ) {
            BlogScreen()
        }
    }
}