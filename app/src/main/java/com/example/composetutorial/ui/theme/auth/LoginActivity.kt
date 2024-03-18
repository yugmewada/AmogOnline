package com.example.composetutorial.ui.theme.auth

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R
import com.example.composetutorial.custom.BlueButton
import com.example.composetutorial.custom.TextFields.CommonTextField
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
        Box(
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
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 25.dp, end = 25.dp)
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier.fillMaxWidth(),
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
                        Toast.makeText(this@LoginActivity, "Please enter name", Toast.LENGTH_SHORT)
                            .show()
                    } else if (isPasswordEmpty) {
                        Toast.makeText(this@LoginActivity, "Please password", Toast.LENGTH_SHORT)
                            .show()
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


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp),
                    horizontalArrangement = Arrangement.Center
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
            }
        }
    }
}