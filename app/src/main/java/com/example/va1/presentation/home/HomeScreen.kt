package com.example.va1.presentation.home

import android.text.Html
import android.text.Spanned
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.foodrecipe.presentations.common.GeneralBottomBar
import com.example.foodrecipe.presentations.common.LoadingAnimation
import com.example.va1.R
import com.example.va1.utils.formatDate

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel<HomeViewModel>(),
    navigateToBlog: (Int) -> Unit
){
    val allBlogs = homeViewModel.allBlogs.collectAsLazyPagingItems()

    Scaffold (
        topBar = { HomeTopBar() },
        bottomBar = { GeneralBottomBar()}
    ){paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(colorResource(id = R.color.white))
        ) {
            items(allBlogs.itemCount) { index ->
                val item = allBlogs[index]
                val title: Spanned = Html.fromHtml(item?.title ?: "Title", Html.FROM_HTML_MODE_LEGACY)

                item?.let {
                    BlogItemCard(
                        title.toString(),
                        formatDate(item.date),
                        { navigateToBlog(item.id) }
                    )
                }
            }
            allBlogs.apply {
                when (loadState.refresh) {
                    is LoadState.Loading -> {
                        item {
                            LoadingAnimation(Modifier.fillMaxWidth())
                        }
                    }
                    is LoadState.Error -> {
                        item {
                            Text(
                                text = "Error occurred while fetching data",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    else -> {}
                }
                when (loadState.append) {
                    is LoadState.Loading -> {
                        item {
                            LoadingAnimation(Modifier.fillMaxWidth())
                        }
                    }
                    is LoadState.Error -> {
                        item {
                            Text(
                                text = "Error Occurred while fetching data",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    is LoadState.NotLoading -> {}
                }
            }

        }
    }
}



