package com.lyst.cat.ui.composables.main_search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lyst.cat.ui.composables.shared.*

@Composable
fun SearchScreen(
    navController: NavController,
    vm: SearchScreenViewModel = hiltViewModel(),
    catClick: (String) -> Unit
) {
    // the cat screen state
    val searchState: SearchScreenState = vm.state.value

    Column {

        // The search box
        CatSearchEditText(vm)

        // put some space in
        Spacer(modifier = Modifier.height(20.dp))

        CatCount(searchState.cats?.count())

        // put some space in
        Spacer(modifier = Modifier.height(20.dp))

        // results column
        if ( searchState.isLoading )
        {
            LoadingSpinner()
        }
        else
        {
            LazyColumn(
                modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)
            ) {

                // The result of the search
                searchState.cats.let {
                    it?.forEach {
                        item {
                            val url = if ( it.reference_image_id.isNullOrBlank() ) null else "https://cdn2.thecatapi.com/images/" + it.reference_image_id + ".jpg"
                            CatItemCard(cat = CatCardDetails(name = it.name, id = it.id, image = url), navigateTo = catClick)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCatSearchEditText()
{
    //CatSearchEditText(vm)
}