package com.example.composetutorial.demos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun showJobList(image:Int, title:String, id:String, type:String, date:String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = cardModifier()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Default image",
                modifier = imageModifier()
            )
            ItemDescription(title, id, type, date)
        }

        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = date,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
private fun ItemDescription(title: String, id: String, type: String, date: String) {
    Column {
        Text(
            text = title,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Text(
            text = "ID: $id",
            color = Color.Gray,
            fontSize = 16.sp
        )

        Text(
            text = "Service Type: $type",
            color = Color.Magenta,
            fontSize = 14.sp
        )
    }
}

private fun imageModifier():Modifier{
    return Modifier
        .size(75.dp)
        .padding(8.dp)
        .clip(CircleShape)

}

private fun cardModifier():Modifier{
    return Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 0.dp)
}
