package com.example.va1.presentation.blog

import android.graphics.Color
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import com.example.va1.R

@Composable
fun BlogWebView(content: String, modifier: Modifier) {
    AndroidView(
        factory = { context ->
            TextView(context).apply {
                text = HtmlCompat.fromHtml(content, HtmlCompat.FROM_HTML_MODE_LEGACY)
                setTextColor(Color.BLACK)
                textSize = 16f
                setLinkTextColor(Color.BLUE)
                movementMethod = LinkMovementMethod.getInstance()
            }
        },
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp, 2.dp, 10.dp, 5.dp)
            .background(color = colorResource(id = R.color.white)),
    )
}

