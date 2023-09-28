package com.example.composetutorial.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R
import com.example.composetutorial.safeclick.MultipleEventsCutter
import com.example.composetutorial.safeclick.MultipleEventsCutterImpl

private fun MultipleEventsCutter.Companion.get(): MultipleEventsCutter = MultipleEventsCutterImpl()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = false, name = "Header")
fun CommonAppHeader(title: String? = "Clothing & Fashion", navigate: (Boolean) -> Unit = {}) {

    Surface(color = colorResource(id = R.color.color_white)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            val multipleEventsCutter = remember { MultipleEventsCutter.get() }
            CenterAlignedTopAppBar(
                modifier = Modifier.background(Color.White),
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                multipleEventsCutter.processEvent {
                                    navigate.invoke(true)
                                }
                            }
                            .layoutId("imageBackArrow")
                            .padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_black_arrow),
                            contentDescription = "Back Arrow",
                        )
                    }
                },
                title = {
                    Text(
                        text = title ?: "",
                        color = colorResource(id = R.color.colorBlack1),
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily(Font(R.font.sofia_pro_semi_bold)),
                        modifier = Modifier
                            .layoutId("textViewTitle")
                            .padding(start = 16.dp)
                    )
                },

                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = colorResource(
                        id = R.color.color_white
                    )
                )
            )
        }
    }
}