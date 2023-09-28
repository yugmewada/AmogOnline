package com.example.composetutorial.ui.theme.home.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
@Preview(showSystemUi = true, name = "Header")
private fun MakeHeader() {
    Surface(color = colorResource(id = R.color.color_white)) {
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
                        modifier = Modifier.padding(top = 5.dp, start = 7.dp)
                    )
                }
            }
        }
    }
}