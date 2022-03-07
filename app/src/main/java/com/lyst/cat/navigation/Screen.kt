package com.lyst.cat.navigation

import com.lyst.cat.R

const val ROOT_ROUTE = "root"
const val HOME_ROUTE = "home"

sealed class Screen(open val title: String, open val route: String) {

    // Bottom navigation main screens
    sealed class BottomNavScreen(override val title: String, override val route: String, var icon:Int) : Screen(title, route){
        object Home : BottomNavScreen("Home" ,"home_screen", R.drawable.vector_home)
        object Search: BottomNavScreen("Search", "search_screen", R.drawable.vector_search)
        object MyCat: BottomNavScreen("My Cat", "mycat_screen", R.drawable.vector_cat_placeholder)
    }

    companion object
    {
        fun mainScreens(): List<BottomNavScreen>
        {
            return listOf(
                BottomNavScreen.Home,
                BottomNavScreen.Search,
                BottomNavScreen.MyCat
            )
        }
    }
}
