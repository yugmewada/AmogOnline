package com.example.composetutorial.ui.theme.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.composetutorial.R
import com.example.composetutorial.custom.BlueButton
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class WelcomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            SetStatusBarColor(color = colorResource(id = R.color.colorBlue3))
            LoginScreenBackGround()
            //navigateUser()
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
    @Preview(
        name = "Login Screen",
        device = Devices.DEFAULT,
        showBackground = true,
        showSystemUi = true
    )
    fun LoginScreenBackGround() {
        Surface {
            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.image_splash_background),
                contentDescription = "Login Screen Background",
                modifier = Modifier.fillMaxSize()
            )

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_hyperlink),
                    contentDescription = "Middle Image",
                    modifier = Modifier
                        .padding(top = 150.dp)
                        .weight(1f)

                )

                BlueButton(
                    text = "Login",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp, top = 50.dp)
                ) {
                    startActivity(
                        Intent(
                            this@WelcomeActivity,
                            LoginActivity::class.java
                        )
                    )
                }

                OutlinedButton(
                    onClick = {
                        Toast.makeText(
                            this@WelcomeActivity,
                            "Login",
                            Toast.LENGTH_LONG
                        ).show()
                    },
                    border = BorderStroke(2.dp, color = colorResource(id = R.color.colorBlue2)),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.color_white)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp, top = 25.dp)
                ) {
                    Text(
                        text = "Create a new account",
                        fontFamily = FontFamily(Font(R.font.sf_bold)),
                        fontSize = 18.sp,
                        color = colorResource(id = R.color.black)
                    )
                }

                Text(
                    text = "Skip now",
                    fontFamily = FontFamily(Font(R.font.sf_regular)),
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.colorBlack_Op50),
                    modifier = Modifier.padding(bottom = 50.dp, top = 25.dp)
                )
            }
        }
    }


}