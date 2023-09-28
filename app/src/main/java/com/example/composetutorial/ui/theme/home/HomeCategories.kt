package com.example.composetutorial.ui.theme.home

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.example.composetutorial.R
import com.example.composetutorial.provider.getHomeProductCategories


@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true, device = Devices.DEFAULT, name = "Home Categories")
@Composable
fun HomeProductCategories() {
    Column(
        modifier = Modifier
            .wrapContentHeight(Alignment.Top)
            .padding(start = 15.dp, end = 15.dp, bottom = 20.dp)
    ) {
        /*Text(
            text = stringResource(id = R.string.label_category_icons),
            fontFamily = FontFamily(Font(R.font.sofia_pro_semi_bold)),
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 14.dp)
        )*/

        CompositionLocalProvider(
            LocalOverscrollConfiguration.provides(null),
        ){
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                content = {
                    items(getHomeProductCategories()) {
                        LoadCategoryData(image = it.image, name = it.name)
                    }
                })
        }
    }
}

@Composable
fun LoadCategoryData(image: String, name: String) {
    Column() {
        LoadImage(image = image)
        Text(
            text = name,
            fontFamily = FontFamily(Font(R.font.sofia_pro_regular)),
            fontSize = 11.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, end = 3.dp)
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

    Box(
        modifier = Modifier
            .clickable {
                Log.e("TAG", "LoadImage: ")
            }
            .fillMaxWidth()
            .padding(top = 15.dp, start = 8.dp, end = 8.dp, bottom = 10.dp)
            .size(106.dp)
            .clip(RoundedCornerShape(14.dp))
            .border(
                border = BorderStroke(2.dp, colorResource(id = R.color.colorGrey2_OP12)),
                shape = RoundedCornerShape(14.dp)
            )

    ) {

        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .size(width = 80.dp, height = 70.dp)
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
