package com.example.va1.presentation.blog

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.va1.models.BlogDC
import com.example.va1.models.toBlogDC
import com.example.va1.navigation.NavigationDestination
import com.example.va1.repository.BlogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


object BlogDestination: NavigationDestination {
    override val route: String = "blog_screen"
    const val blogIdArgs = "blog_id"
    val routeWithArgs = "$route/{$blogIdArgs}"
}

@HiltViewModel
class BlogViewModel @Inject constructor(
    private val repo: BlogRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    val id : Int = checkNotNull(savedStateHandle[BlogDestination.blogIdArgs])

    val blog = MutableStateFlow<BlogDC>(BlogDC())

    init {
        get()
    }
    fun get(){
        viewModelScope.launch { repo.getById(id).collect { blog.value = it.toBlogDC() } }
    }
}