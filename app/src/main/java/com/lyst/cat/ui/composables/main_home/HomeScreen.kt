package com.lyst.cat.ui.composables.main_home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lyst.cat.ui.composables.shared.CatCount
import com.lyst.cat.ui.composables.shared.CatCardDetails
import com.lyst.cat.ui.composables.shared.CatItemCard
import com.lyst.cat.ui.composables.shared.LoadingSpinner

@Composable
fun HomeScreen(
    navController: NavController,
    vm: HomeScreenViewModel = hiltViewModel(),
    catClick: (String) -> Unit
) {
    // the cat screen state
    val homeState: HomeScreenState = vm.state.value

    Column {

        // put some space in
        Spacer(modifier = Modifier.height(20.dp))

        // The cat count
        CatCount(homeState.cats?.count())

        // put some space in
        Spacer(modifier = Modifier.height(20.dp))

        // spinner or show the cat list
        if ( homeState.isLoading )
        {
            LoadingSpinner()
        }
        else
        {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {

                // Each cat
                homeState.cats.let {
                    it?.forEach {
                        item {
                            CatItemCard(
                                cat = CatCardDetails("${it.name}", id = it.id, it.image?.url),
                                navigateTo = catClick
                            )
                        }
                    }
                }
            }
        }
    }
}
