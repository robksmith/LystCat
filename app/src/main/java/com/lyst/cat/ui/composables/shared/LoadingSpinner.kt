package com.lyst.cat.ui.composables.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoadingSpinner()
{
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center ) {
        CircularProgressIndicator(
            modifier = Modifier, color = Color.Red
        )
    }
}

@Preview
@Composable
fun PreviewLoading()
{
    LoadingSpinner()
}
