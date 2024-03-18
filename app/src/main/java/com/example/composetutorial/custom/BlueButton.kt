package com.example.composetutorial.custom

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R
import com.example.composetutorial.ui.theme.auth.LoginActivity
import com.example.composetutorial.custom.TextFields.startActivity

@Composable
fun BlueButton(text: String, modifier: Modifier, onClick: () -> Unit) {
    Button(
        onClick = {
            onClick.invoke()
        },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.colorBlue2)),
        shape = RoundedCornerShape(4.dp),
        modifier = modifier

    ) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.sf_bold)),
            fontSize = 18.sp
        )
    }
}

@Composable
private fun ShowMessage() {
    val snackBarHostState = remember { SnackbarHostState() }
    SnackbarHost(
        hostState = snackBarHostState,
    )
}