package com.example.composetutorial.custom

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R
import com.example.composetutorial.safeclick.MultipleEventsCutter
import com.example.composetutorial.safeclick.MultipleEventsCutterImpl

private fun MultipleEventsCutter.Companion.get(): MultipleEventsCutter = MultipleEventsCutterImpl()

@Preview(name = "Search Field")
@Composable
fun CustomSearchField(
    leadingIcon: Int? = R.drawable.ic_search_grey,
    trailingIcon: Int? = null,
    hint: String? = null,
    modifier: Modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
        .fillMaxWidth()
        .size(48.dp),
    isEnabled: Boolean = true
) {
    val multipleEventsCutter = remember { MultipleEventsCutter.get() }

    Card(
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.color_white)),
        border = BorderStroke(1.dp, colorResource(id = R.color.colorGrey2_OP12)),
        elevation = CardDefaults.cardElevation(3.dp),
        shape = RoundedCornerShape(13.dp),
        modifier = modifier

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.background(Color.White)
        ) {

            if (leadingIcon != null) {
                Image(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = "Search Image",
                    modifier = Modifier
                        .padding(start = 20.dp, top = 0.dp, end = 6.dp)
                        .fillMaxHeight(),
                )
            }
            hint?.let {
                SearchField(
                    isEnabled = isEnabled,
                    placeHolder = it,
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxHeight()
                        .weight(1f)
                )
            }


            if (trailingIcon != null) {
                Image(
                    painter = painterResource(id = trailingIcon),
                    contentDescription = "Filter Image",
                    modifier = Modifier
                        .padding(start = 20.dp, top = 0.dp, end = 18.dp)
                        .fillMaxHeight()
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            multipleEventsCutter.processEvent {
                                Log.e("TAG", "Filter click  ")
                            }
                        },

                    )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchField(modifier: Modifier, placeHolder: String, isEnabled: Boolean) {
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
            fontFamily = FontFamily(Font(R.font.sofia_pro_regular)),
            fontSize = 14.sp
        ),
        singleLine = true,
        enabled = isEnabled

    ) { innerTextField ->
        TextFieldDefaults.TextFieldDecorationBox(
            value = value,
            visualTransformation = VisualTransformation.None,
            innerTextField = innerTextField,
            singleLine = true,
            interactionSource = interactionSource,
            contentPadding = PaddingValues(start = 0.dp, end = 10.dp),
            enabled = isEnabled,
            placeholder = {
                Text(
                    placeHolder,
                    fontFamily = FontFamily(Font(R.font.sofia_pro_regular)),
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.colorGrey)
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