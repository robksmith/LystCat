package com.lyst.cat.ui.composables.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.lyst.cat.R

data class CatCardDetails(val name: String, val id:String, val image: String?)

@Composable
fun CatItemCard(cat: CatCardDetails, navigateTo: (String) -> Unit)
{
    Card(
        modifier = Modifier
            .aspectRatio(1.5f)
            .padding(12.dp)
            .clickable {navigateTo(cat.id)},
        shape = RoundedCornerShape(22.dp),
        backgroundColor = Color.Red,
        elevation = 25.dp
    ) {
        ConstraintLayout(
            modifier = Modifier.background(Color.White)
        ) {

            val (image, textName, textAddress, textAmount, actionButton, button1, button2) = createRefs()

            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(image) {},
                painter = if ( cat.image==null) painterResource(id = R.drawable.vector_cat_placeholder) else rememberImagePainter(cat.image),
                contentDescription = "Image 1",
            )

            Text(
                modifier = Modifier
                    .constrainAs(textAmount) {
                        bottom.linkTo(image.bottom)
                        start.linkTo(image.start)
                    }
                    .padding(start = 20.dp, bottom = 20.dp)
                    .background(Color.Gray)
                    .padding(3.dp)
                ,
                text = "${cat.name}",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun Preview1()
{
    CatItemCard(cat = CatCardDetails("lyst top cat", "sphy", null)) {}
}