package com.lyst.cat.ui.composables.main_mycat

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun MyCatScreen(
    navController: NavController,
    vm: MyCatScreenViewModel = hiltViewModel()
) {
    // nothing here - this is the third cat tab
}
