package com.lyst.cat.ui.composables.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


@Composable
fun CatCount(count:Int?)
{
    if ( count == null || count < 1) return

    Text(
        modifier = Modifier
            .padding(start = 20.dp)
            .background(Color.Gray)
            .padding(3.dp)
        ,
        text = "Cats in list : ${count}",
        color = MaterialTheme.colors.onPrimary,
        style = MaterialTheme.typography.body1,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}