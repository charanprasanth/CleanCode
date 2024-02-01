package com.example.cleancode.domain.use_case.get_posts

import com.example.cleancode.common.Resource
import com.example.cleancode.data.remote.dto.toPost
import com.example.cleancode.data.remote.dto.toUser
import com.example.cleancode.domain.model.Post
import com.example.cleancode.domain.model.User
import com.example.cleancode.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<Resource<List<Post>>> = flow {
        try {
            emit(Resource.Loading<List<Post>>())
            val posts = repository.getPosts().map { it.toPost() }
            emit(Resource.Success<List<Post>>(posts))
        } catch (e: HttpException) { //related to network non-2.x.x
            emit(Resource.Error<List<Post>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) { //when server cannot be reached (ex: no internet)
            emit(Resource.Error<List<Post>>("Couldn't reach server, check you internet connection"))
        }
    }
}