package com.example.va1.models

import androidx.paging.Pager
import androidx.paging.PagingData
import com.example.va1.local.BlogRDC
import com.example.va1.network.BlogNDC
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun BlogNDC.toBlogRDC() : BlogRDC {
    return BlogRDC(
        this.id,
        this.date,
        this.title.rendered,
        this.content.rendered
    )
}

fun BlogRDC.toBlogDC(): BlogDC {
    return BlogDC(
        id = this.id,
        date = this.date,
        title = this.title,
        content = this.content
    )
}

fun BlogNDC.toBlogDC(): BlogDC {
    return BlogDC(
        this.id,
        this.date,
        this.title.rendered,
        this.content.rendered
    )
}