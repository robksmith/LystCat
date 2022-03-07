package com.lyst.cat.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.*
import androidx.navigation.compose.rememberNavController
import com.lyst.cat.R
import com.lyst.cat.navigation.nav_graph.SetupRootNavGraph
import com.lyst.cat.navigation.Screen
import com.lyst.cat.ui.composables.shared.BottomNavigationMain
import com.lyst.cat.ui.theme.LystCatApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LystCatApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {

                    navController = rememberNavController()

                    Scaffold(
                        topBar = {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(1.0f)
                                    .padding(8.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Box(modifier = Modifier.fillMaxWidth()
                                    .background(Color.White)
                                    .padding(10.dp)) {

                                    Image(
                                        modifier = Modifier.align(Alignment.CenterEnd),
                                        painter = painterResource(R.drawable.vector_settings),
                                        contentDescription = "Top Bar",
                                        contentScale = ContentScale.Fit,
                                        colorFilter = ColorFilter.tint(Color(0xFF232323)),
                                        alignment = Alignment.CenterEnd
                                    )

                                    Text(
                                        modifier = Modifier.align(Alignment.CenterStart),
                                        text = "Lyst Cat Demo",
                                        style = MaterialTheme.typography.h5,
                                    )
                                }

                                Divider(color = Color.LightGray, thickness = 1.dp)
                            }
                        },

                        content = { innerPadding ->
                            SetupRootNavGraph(navController, modifier = Modifier.padding(innerPadding))
                        },

                        bottomBar = {
                            BottomNavigationMain(navController = navController, screens = Screen.mainScreens())
                        })
                }
            }
        }
    }
}