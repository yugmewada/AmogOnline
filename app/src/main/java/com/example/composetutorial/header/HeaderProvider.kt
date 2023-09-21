package com.example.composetutorial.header

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R
import java.util.Stack


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun CommonAppHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        CenterAlignedTopAppBar(
            modifier = Modifier.background(Color.White),
            navigationIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_black_arrow),
                    contentDescription = "Back Arrow",
                    modifier = Modifier
                        .clickable {
                            Log.d("TAG", "CommonAppHeader: ")
                        }
                        .layoutId("imageBackArrow")
                        .padding(16.dp)

                )
            },
            title = {
                Text(
                    text = stringResource(id = R.string.label_clothing_fashion),
                    color = colorResource(id = R.color.colorBlack1),
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_semi_bold)),
                    modifier = Modifier
                        .layoutId("textViewTitle")
                        .padding(start = 16.dp)
                )
            }
        )
    }
}
