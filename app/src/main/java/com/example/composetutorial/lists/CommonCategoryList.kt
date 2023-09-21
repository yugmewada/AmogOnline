package com.example.composetutorial.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.R
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.annotation.ExperimentalCoilApi
import coil.transform.RoundedCornersTransformation

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun CommonCategoryList(name: String = "Yug", image: String = "") {
    Column(

        modifier = Modifier
            .background(colorResource(id = R.color.color_white))
            .padding(bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 15.dp, top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            LoadImage(image)

            Text(
                text = name,
                fontFamily = FontFamily(Font(R.font.sofia_pro_semi_bold)),
                color = colorResource(id = R.color.colorBlack2),
                modifier = Modifier.padding(start = 16.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )

        }

        Divider(
            color = colorResource(id = R.color.colorGrey1_OP14),
            modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
                .padding(start = 97.dp, end = 15.dp)
        )
    }
}

@Composable
@OptIn(ExperimentalCoilApi::class)
private fun LoadImage(image: String) {
    var isLoading by rememberSaveable { mutableStateOf(true) }

    val painter = rememberImagePainter(
        data = image,
        builder = {
            transformations(RoundedCornersTransformation(14f))
        }
    )

    Box(modifier = Modifier.size(65.01.dp)) {

        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .size(65.01.dp)
                .clip(RoundedCornerShape(14.dp))
        )

        if (painter.state is ImagePainter.State.Loading) {
            CircularProgressIndicator(
                color = Color.Gray,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        DisposableEffect(image) {
            val state = painter.state
            if (state is ImagePainter.State.Success || state is ImagePainter.State.Error) {
                isLoading = false
            }
            onDispose {

            }
        }
    }
}

