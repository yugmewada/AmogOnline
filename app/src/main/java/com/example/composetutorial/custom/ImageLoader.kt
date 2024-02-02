package com.example.composetutorial.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation

@Composable
@OptIn(ExperimentalCoilApi::class)
fun LoadImage(image: String?, modifier: Modifier) {
    var isLoading by rememberSaveable { mutableStateOf(true) }

    val painter = rememberImagePainter(
        data = image,
        builder = {
            transformations(RoundedCornersTransformation(14f))
        }
    )

    Box {

        Image(
            painter = painter,
            contentDescription = "",
            modifier = modifier
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