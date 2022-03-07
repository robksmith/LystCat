package com.lyst.cat.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.lyst.cat.navigation.HOME_ROUTE
import com.lyst.cat.navigation.ROOT_ROUTE
import com.lyst.cat.navigation.nav_graph.setupBottomNavGraph
import kotlin.time.ExperimentalTime

@Composable
fun SetupRootNavGraph(navController: NavHostController, modifier: Modifier = Modifier)
{
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        modifier = modifier,
        route = ROOT_ROUTE
    ) {
        setupBottomNavGraph(navController = navController)
    }
}