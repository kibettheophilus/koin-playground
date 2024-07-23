package com.theophiluskibet.koin.playground.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theophiluskibet.koin.playground.presentation.screens.details.CharacterDetailScreen
import com.theophiluskibet.koin.playground.presentation.screens.list.CharacterListScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = "home",
    ) {
        composable("home") {
            CharacterListScreen(
                onCharacterClick = { id ->
                    navController.navigate("details/$id")
                },
            )
        }
        composable("details/{id}") {
            CharacterDetailScreen(
                id = it.arguments?.getString("id").toString(),
                onNavigateUp = { navController.navigateUp() },
            )
        }
    }
}
