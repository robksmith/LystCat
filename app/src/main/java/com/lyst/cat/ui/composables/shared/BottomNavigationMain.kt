package com.lyst.cat.ui.composables.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lyst.cat.navigation.Screen

@Composable
fun BottomNavigationMain(navController: NavController, screens: List<Screen.BottomNavScreen>) {
    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(30.dp, 30.dp, 30.dp, 30.dp)),
        elevation = 8.dp,
        contentColor = Color.Black,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        screens.forEach { item ->
            BottomNavigationItem(
                modifier = Modifier,
                icon = {
                Icon(
                    painterResource(id = item.icon),
                    contentDescription = item.title
                )
            },
                label = { Text(text = item.title, fontSize = 12.sp) },
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.Blue.copy(0.3f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}

@Preview
@Composable
fun BottomNavPreview()
{
    BottomNavigationMain(navController = rememberNavController(), screens = Screen.mainScreens())
}