package com.example.va1.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.presentations.common.GeneralTopBar
import com.example.va1.R

@Composable
fun HomeTopBar() {
    Column {
        GeneralTopBar()
        TopAppBar(title = {
            Text(text = "Blogs Application",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp)
        },
            backgroundColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.black))
    }
}