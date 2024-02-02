package com.example.composetutorial.ui.theme.home.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R
import com.example.composetutorial.custom.CustomSearchField
import com.example.composetutorial.custom.LoadImage
import com.example.composetutorial.provider.getAdvertiseBanner

open class HomeActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeHeader()
        }
    }
}


@Composable
@Preview(showSystemUi = true, name = "Header")
fun MakeHeader() {
    Surface(color = colorResource(id = R.color.color_white)) {

        //Header Section
        Column {
            MainHeader()

            //Search Bar
            MakeSearchField()

            //Live Banners
            MakeSlider()

            //Open Market View
            VisitOpenMarketView()

            Text(
                text = stringResource(id = R.string.label_category_icons),
                fontFamily = FontFamily(Font(R.font.sofia_pro_semi_bold)),
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp, top = 14.dp)
            )
        }
    }
}

@Composable
private fun MakeSearchField() {
    Surface(
        color = colorResource(id = R.color.color_white),
        modifier = Modifier.padding(top = 18.dp)
    ) {
        CustomSearchField(
            isEnabled = false,
            hint = stringResource(id = R.string.hint_search_what_are_you_looking_for),
            trailingIcon = R.drawable.ic_filter,
            modifier = Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {

                    Log.e("TAG", "MakeHeader: ")
                }
                .padding(start = 16.dp, end = 16.dp, bottom = 3.dp)
                .fillMaxWidth()
                .size(48.dp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MakeSlider() {
    CompositionLocalProvider(
        LocalOverscrollConfiguration.provides(null),
    ) {
        LazyRow(
            modifier = Modifier.padding(start = 8.dp, end = 16.dp),
            content = {
                items(getAdvertiseBanner()) { imageData ->
                    Box(
                        modifier = Modifier.padding(top = 17.dp, start = 8.dp, end = 8.dp)
                    ) {
                        Card(
                            elevation = CardDefaults.cardElevation(0.dp),
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier.fillMaxWidth()

                        ) {
                            LoadImage(
                                image = imageData.image,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .size(height = 199.dp, width = 313.dp)
                                    .clip(RoundedCornerShape(14.dp))
                            )
                        }

                        OutlinedButton(
                            onClick = {},
                            border = BorderStroke(1.dp, colorResource(id = R.color.color_white)),
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = colorResource(id = R.color.colorBlue)
                            ),
                            shape = RoundedCornerShape(20.dp),
                            contentPadding = PaddingValues(start = 15.dp, end = 15.dp),
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(end = 11.dp, bottom = 8.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.label_visit_now),
                                fontSize = 11.sp,
                                fontFamily = FontFamily(Font(R.font.sofia_pro_regular)),
                                color = colorResource(id = R.color.color_white)
                            )
                        }
                    }
                }
            })
    }
}

@Composable
private fun MainHeader() {

    Row(
        modifier = Modifier
            .wrapContentHeight(Alignment.Top)
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
    ) {

        Card(
            modifier = Modifier.size(50.dp),
            elevation = CardDefaults.cardElevation(5.dp),
            shape = RoundedCornerShape(CornerSize(50))

        ) {
            Image(
                painter = painterResource(id = R.drawable.place_holder),
                contentDescription = "User Image",
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(CornerSize(50)))
                    .border(
                        width = 1.dp,
                        color = colorResource(id = R.color.color_white),
                        shape = RoundedCornerShape(CornerSize(50))
                    )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
        ) {
            Text(
                text = "Welcome to Amog Online",
                fontFamily = FontFamily(Font(R.font.play_fair_display_bold)),
                color = Color.Black,
                fontSize = 13.sp
            )

            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_location_blue),
                    contentDescription = "Location Image Icon",
                )
                Text(
                    text = "San Francisco",
                    fontFamily = FontFamily(Font(R.font.sofia_pro_medium)),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.colorBlue),
                    modifier = Modifier
                        .padding(top = 5.dp, start = 7.dp)
                        .widthIn(0.dp, 150.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_small_down_arrow),
                    contentDescription = "Dropdown Arrow",
                    modifier = Modifier.padding(start = 10.dp, bottom = 4.dp)
                )
            }
        }
    }
}

@Composable()
@Preview(name = "Visit open market view")
private fun VisitOpenMarketView() {
    Surface(
        color = colorResource(id = R.color.colorBlue),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(CornerSize(7.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_open_market_diamond),
                contentDescription = "OpenMarket Diamond Image",
                modifier = Modifier.padding(
                    start = 15.dp,
                    top = 10.dp,
                    bottom = 10.dp,
                    end = 19.dp
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),

                ) {
                Text(
                    text = stringResource(id = R.string.label_visit_open_market),
                    color = colorResource(id = R.color.color_white),
                    fontFamily = FontFamily(Font(R.font.sofia_pro_semi_bold)),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 12.dp)
                )

                Text(
                    text = stringResource(id = R.string.dummy_lorem_ipsum_open_market),
                    color = colorResource(id = R.color.color_white),
                    fontFamily = FontFamily(Font(R.font.sofia_pro_light)),
                    fontSize = 11.sp,
                    modifier = Modifier.padding(top = 3.4.dp, bottom = 11.3.dp)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_black_right_arrow_open_market),
                contentDescription = "Next Arrow",
                colorFilter = ColorFilter.tint(colorResource(id = R.color.color_white)),
                modifier = Modifier.padding(end = 17.33.dp)
            )
        }
    }
}

