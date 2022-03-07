package com.lyst.cat.navigation.nav_graph

import android.content.Intent
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.lyst.cat.navigation.HOME_ROUTE
import com.lyst.cat.navigation.Screen
import com.lyst.cat.ui.activities.CatDetailActivity
import com.lyst.cat.ui.composables.main_home.HomeScreen
import com.lyst.cat.ui.composables.main_mycat.MyCatScreen
import com.lyst.cat.ui.composables.main_search.SearchScreen

fun NavGraphBuilder.setupBottomNavGraph(
    navController:NavHostController
)
{
    navigation(
        startDestination = Screen.BottomNavScreen.Home.route,
        route = HOME_ROUTE
    )
    {

        // for this demo, this lambda simply launches another activity which will contain the cat detail - not sure in a real app I would do this
        val catClick = { p:String ->
            val intent = Intent(navController.context, CatDetailActivity::class.java)
            intent.putExtra("catid", p)
            navController.context.startActivity(intent)
        }

        composable(Screen.BottomNavScreen.Home.route) {
            HomeScreen(navController) { p:String ->
                catClick(p)
            }
        }
        composable(Screen.BottomNavScreen.Search.route) {
            SearchScreen(navController){ p:String ->
                catClick(p)
            }
        }
        composable(Screen.BottomNavScreen.MyCat.route) {
            MyCatScreen(navController)
        }
    }
}