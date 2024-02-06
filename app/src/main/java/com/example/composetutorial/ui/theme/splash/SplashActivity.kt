package com.example.composetutorial.ui.theme.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.composetutorial.R
import com.example.composetutorial.auth.WelcomeActivity
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        //WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = false
        setContent {
            SetStatusBarColor(color = colorResource(id = R.color.colorBlue3))
            SplashBackground()
        }

        lifecycleScope.launch {
            delay(2000)
            startActivity(Intent(this@SplashActivity, WelcomeActivity::class.java))
            finishAffinity()
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
    fun SplashBackground() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.image_splash_background),
                contentDescription = "Image splash background",
                modifier = Modifier.fillMaxSize()
            )

            Image(
                painter = painterResource(id = R.drawable.image_hyperlink),
                contentDescription = "Center Image",
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.Center),
            )
        }
    }

    @Preview(name = "Splash Screen", showSystemUi = true, device = Devices.DEFAULT)
    @Composable
    fun MyViewPreview() {
        SplashBackground()
    }
}