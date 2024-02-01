package com.example.cleancode.presentation.posts_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleancode.common.Resource
import com.example.cleancode.domain.use_case.get_posts.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostsListViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(PostsListState())
    val state: State<PostsListState> = _state

    init {
        getPosts()
    }

    private fun getPosts() {
        getPostsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PostsListState(posts = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PostsListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PostsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}