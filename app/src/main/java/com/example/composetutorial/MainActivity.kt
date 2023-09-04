package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.header.CommonAppHeader
import com.example.composetutorial.lists.CommonCategoryList
import com.example.composetutorial.provider.getCategoryData


class MainActivity : ComponentActivity() {


    @Preview(showBackground = false, showSystemUi = true, device = Devices.NEXUS_5, name = "MyPreview")
    @Composable
    fun ShowPreview() {
        setData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setData()
        }
    }
}

@Composable
private fun setData(){

    val scrollState = rememberLazyListState()

    Column(modifier = Modifier.fillMaxWidth()){
        CommonAppHeader()
        Divider(
            color = colorResource(id = R.color.colorGrey1_OP4),
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .padding(top = 25.dp)
        )
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize(),
            content = {
            items(getCategoryData()){
                CommonCategoryList(name = it.name, image = it.image)
            }
        })
    }
}

/*@Composable
private fun searchBar() {
    val state = rememberSaveable() { mutableStateOf("") }

    FormTextField(
        value = state.value,
        onValueChange = { state.value = it },
        placeholder = stringResource(id = R.string.hint_search_here),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search_grey),
                contentDescription = "Search"
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color.White),
        fontFamily = FontFamily(Font(R.font.sofia_pro_regular)),
        shape = RoundedCornerShape(12.dp)
    )
}*/







