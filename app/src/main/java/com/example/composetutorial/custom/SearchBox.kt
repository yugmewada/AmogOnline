package com.example.composetutorial.custom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.R


@Preview(name = "Search Field")
@Composable
fun CustomSearchField() {

    Card(
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.color_white)),
        border = BorderStroke(1.dp, colorResource(id = R.color.colorGrey2_OP12)),
        elevation = CardDefaults.cardElevation(3.dp),
        shape = RoundedCornerShape(13.dp),
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .size(48.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(Color.White)
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_search_grey),
                contentDescription = "Search Image",
                modifier = Modifier
                    .padding(start = 20.dp, top = 0.dp, end = 6.dp)
                    .fillMaxHeight(),
            )
            SearchField(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchField(modifier: Modifier) {
    val interactionSource = remember { MutableInteractionSource() }
    var value by rememberSaveable { mutableStateOf("") }

    BasicTextField(
        value = value,
        onValueChange = { value = it },
        modifier = modifier,
        visualTransformation = VisualTransformation.None,
        interactionSource = interactionSource,
        textStyle = TextStyle(
            color = colorResource(id = R.color.black),
            fontFamily = FontFamily(Font(R.font.sofia_pro_regular))
        ),
        singleLine = true

    ) { innerTextField ->
        TextFieldDefaults.TextFieldDecorationBox(
            value = value,
            visualTransformation = VisualTransformation.None,
            innerTextField = innerTextField,
            singleLine = true,
            interactionSource = interactionSource,
            contentPadding = PaddingValues(start = 0.dp, end = 10.dp),
            enabled = true,
            placeholder = {
                Text(
                    stringResource(id = R.string.hint_search_here),
                    fontFamily = FontFamily(Font(R.font.sofia_pro_regular)),
                )
            },

            colors = TextFieldDefaults.textFieldColors(
                placeholderColor = colorResource(id = R.color.colorGrey),
                textColor = colorResource(id = R.color.black),
                cursorColor = colorResource(id = R.color.black),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.White
            ),
        )
    }
}