package com.example.va1.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun formatTime(time: String): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

    try {
        val time2 = sdf.parse(time)
        val sdf2 = SimpleDateFormat("hh:mm a")
        return sdf2.format(time2!!)
    }
    catch (e: Exception){
        return ""
    }
}


@SuppressLint("SimpleDateFormat")
fun formatDate(date: String): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

    try {
        val date2 = sdf.parse(date)
        val sdf2 = SimpleDateFormat("MMM - dd, yyyy")
        return sdf2.format(date2!!)
    }catch (e: Exception){
        return ""
    }
}
