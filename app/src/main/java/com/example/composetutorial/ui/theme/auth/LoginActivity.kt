package com.example.composetutorial.ui.theme.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R
import com.example.composetutorial.custom.BlueButton
import com.example.composetutorial.custom.TextFields.CommonTextField
import com.example.composetutorial.ui.theme.home.screens.HomeActivity
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class LoginActivity : ComponentActivity() {

    private var isNameEmpty: Boolean = true
    private var isPasswordEmpty: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetStatusBarColor(color = colorResource(id = R.color.colorBlue3))
            SetBackground()
        }
    }

    @Composable
    fun SetStatusBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(color)
        }
    }

    @Composable
    @Preview(name = "Login Background", showSystemUi = true, device = Devices.DEFAULT)
    private fun SetBackground() {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .scrollable(
                    orientation = Orientation.Vertical, state = rememberScrollState()
                )
        ) {
            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.image_splash_background),
                contentDescription = "Login Screen Background",
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp)
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier,
                    fontFamily = FontFamily(Font(R.font.sf_bold)),
                    fontSize = 24.sp,
                )

                CommonTextField(
                    isPassword = false,
                    leadingIcon = R.drawable.ic_person,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
                    ),
                    placeHolder = "Phone number, email or username",
                    modifier = Modifier.fillMaxWidth()
                ) {
                    isNameEmpty = it
                }

                CommonTextField(
                    isPassword = true,
                    leadingIcon = R.drawable.ic_lock,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password, imeAction = ImeAction.Next
                    ),
                    placeHolder = "Password",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                ) {
                    isPasswordEmpty = it
                }

                Text(
                    text = "Need help logging in?", style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.sf_regular)),
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.colorBlack3)
                    ), modifier = Modifier.padding(top = 25.dp)
                )

                BlueButton(
                    text = "Login", modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp)
                ) {

                    if (isNameEmpty) {
                        Toast.makeText(
                            this@LoginActivity, "Please enter name", Toast.LENGTH_SHORT
                        ).show()
                    } else if (isPasswordEmpty) {
                        Toast.makeText(
                            this@LoginActivity, "Please password", Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT)
                            .show()
                    }

                }

                Text(
                    text = "or", style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.sf_regular)),
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.colorBlack3),
                        textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp)
                )


            }


            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()

            ) {

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_apple),
                        contentDescription = "Apple Login"
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = "Google Login",
                        modifier = Modifier.padding(start = 28.dp, end = 27.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_fb),
                        contentDescription = "Fb Login"
                    )
                }

                val signup = "Sign up"
                val annotatedStringSignUp = createSpannableText(
                    mainText = "Don’t have an account? ",
                    text = signup,
                    color = colorResource(id = R.color.colorBlue2),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sf_bold)),
                    underlineText = "Yug"
                )

                ClickableText(
                    modifier = Modifier.padding(top = 25.dp, bottom = 20.dp),
                    text = annotatedStringSignUp,
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.sf_regular))),
                    onClick = { offset ->
                        annotatedStringSignUp.getStringAnnotations("ClickableSpan", offset, offset)
                            .firstOrNull()?.let { span ->
                                startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                                println(this.hashCode())
                            }
                    })

            }
        }
    }

    @Composable
    private fun createSpannableText(
        mainText:String,
        text: String,
        color: Color,
        fontSize: TextUnit,
        fontFamily: FontFamily,
        underlineText: String? = null
    ): AnnotatedString {
        val words = text.split(" ")

        return AnnotatedString.Builder().apply {
            append(mainText)
            words.forEachIndexed { index, word ->
                val start = length
                val end = start + word.length

                val style = if (word == underlineText) {
                    SpanStyle(textDecoration = TextDecoration.Underline)
                } else {
                    SpanStyle(color = color, fontSize = fontSize, fontFamily = fontFamily)
                }

                addStyle(style, start, end)

                if (word == underlineText) {
                    addStringAnnotation("ClickableSpan", "ClickableSpan", start, end)
                }

                append(word)

                if (index < words.size - 1) append(" ")
            }
        }.toAnnotatedString()
    }
}