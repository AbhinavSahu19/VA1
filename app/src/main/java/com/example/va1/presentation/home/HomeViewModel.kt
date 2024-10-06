package com.example.va1.presentation.home

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.va1.local.BlogRDC
import com.example.va1.models.BlogDC
import com.example.va1.models.toBlogDC
import com.example.va1.navigation.NavigationDestination
import com.example.va1.repository.BlogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


object HomeDestination: NavigationDestination{
    override val route: String = "home_screen"
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    repo: BlogRepository
) : ViewModel() {
    val allBlogs = repo.getAllBlogs().flow.cachedIn(viewModelScope)
}
