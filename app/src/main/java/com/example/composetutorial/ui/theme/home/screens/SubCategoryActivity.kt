package com.example.composetutorial.ui.theme.home.screens

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.R
import com.example.composetutorial.custom.CommonAppHeader
import com.example.composetutorial.custom.CustomSearchField
import com.example.composetutorial.lists.CommonCategoryList
import com.example.composetutorial.provider.getCategoryData

class SubCategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetUIData()
        }
    }

    @Composable
    @Preview(showSystemUi = true, name = "Category Screen Data", device = Devices.DEFAULT)
    private fun SetUIData() {
        Column(
            modifier = Modifier.background(Color.White)
        ) {
            CommonAppHeader(title = stringResource(id = R.string.label_clothing_fashion)) {
                Toast.makeText(this@SubCategoryActivity, "Hello World", Toast.LENGTH_SHORT).show()
            }
            Column {
                CustomSearchField()
                Divider(
                    thickness = 4.dp,
                    color = colorResource(id = R.color.colorGrey1_OP4),
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
            SetCategoryData()
        }
    }


    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    private fun SetCategoryData() {
        CompositionLocalProvider(
            LocalOverscrollConfiguration.provides(null),
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                content = {
                    items(getCategoryData()) {
                        CommonCategoryList(
                            name = it.name,
                            image = it.image
                        )
                    }
                })
        }
    }
}