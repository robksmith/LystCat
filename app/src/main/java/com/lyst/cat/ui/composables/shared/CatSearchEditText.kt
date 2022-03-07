package com.lyst.cat.ui.composables.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.lyst.cat.ui.composables.main_search.SearchScreenViewModel

@Composable
fun CatSearchEditText(vm: SearchScreenViewModel)
{
    val breedSearchText = vm.query.value

    TextField(
        value = breedSearchText,
        onValueChange = { newValue:String -> vm.onSearchTermChanged(newValue.take(20)) },
        label = { Text("Enter cat breed") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go, keyboardType = KeyboardType.Text),
        keyboardActions = KeyboardActions(onGo = {vm.onMakeCall()}),
        placeholder = { Text("Cat breed") },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color(0xFFaaaaaa), cursorColor = Color.Red, textColor = Color.White),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    )
}