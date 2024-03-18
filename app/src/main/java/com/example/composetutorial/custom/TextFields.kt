package com.example.composetutorial.custom

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R

object TextFields : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CommonTextField(
        isPassword: Boolean = false,
        leadingIcon: Int? = null,
        trailingIcon: Int? = null,
        placeHolder: String,
        keyboardOptions: KeyboardOptions,
        modifier: Modifier,
        isEmpty :(Boolean) -> Unit
    ) {

        var showPassword by remember { mutableStateOf(true) }
        var resultantData by rememberSaveable {
            mutableStateOf("")
        }

        TextField(
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = colorResource(id = R.color.colorBlue2_OP21),
                unfocusedIndicatorColor = colorResource(id = R.color.colorBlue2_OP21),
                cursorColor = colorResource(id = R.color.colorBlack1),
                textColor = colorResource(id = R.color.colorBlack1)

            ),
            textStyle = TextStyle.Default.copy(
                fontSize = 14.sp,
                color = colorResource(id = R.color.colorBlack1),
                fontFamily = FontFamily(Font(R.font.sf_semi_bold))
            ),
            value = resultantData,

            onValueChange = {
                resultantData = it
                isEmpty.invoke(it.isNotEmpty())
            },
            keyboardOptions =
            if (isPassword)
                KeyboardOptions(keyboardType = KeyboardType.Password)
            else
                keyboardOptions,

            modifier = modifier,

            leadingIcon = {

                if (leadingIcon != null) {
                    Image(
                        painter = painterResource(leadingIcon),
                        contentDescription = "leadingIcon"
                    )
                }
            },
            trailingIcon = {
                if (isPassword) {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Image(
                            painter = painterResource(
                                if (showPassword)
                                    R.drawable.ic_pass_invisible
                                else
                                    R.drawable.ic_pass_invisible
                            ),
                            contentDescription = "Toggle Password Visibility"
                        )
                    }
                } else if (trailingIcon != null) {
                    Image(
                        painter = painterResource(id = trailingIcon),
                        contentDescription = "trailingIcon"
                    )
                }

            },
            visualTransformation = setVisualTransformation(
                isPass = isPassword,
                visualState = showPassword
            ),
            placeholder = {
                Text(
                    text = placeHolder,
                    maxLines = 1,
                    style = TextStyle(
                        color = colorResource(id = R.color.colorBlack_Op50),
                        fontFamily = FontFamily(Font(R.font.sf_semi_bold)),
                        fontSize = 14.sp
                    )
                )
            }
        )
    }

    private fun setVisualTransformation(
        isPass: Boolean,
        visualState: Boolean
    ): VisualTransformation {
        return if (isPass && visualState) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }
    }
}