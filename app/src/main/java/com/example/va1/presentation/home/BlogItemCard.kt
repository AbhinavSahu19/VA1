package com.example.va1.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.va1.R

@Composable
fun BlogItemCard(
    title: String,
    date: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { onClick() },
        backgroundColor = colorResource(id = R.color.white),
        border = BorderStroke(1.dp, colorResource(id = R.color.border_gray)),
        shape = RoundedCornerShape(10.dp)
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 2.dp)
                .background(colorResource(id = R.color.white))
        ){
            Text(text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.black))
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = date,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.text_gray))
        }
    }
}
