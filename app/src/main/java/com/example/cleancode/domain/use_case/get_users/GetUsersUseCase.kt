package com.example.cleancode.domain.use_case.get_users

import com.example.cleancode.common.Resource
import com.example.cleancode.data.remote.dto.toUser
import com.example.cleancode.domain.model.Post
import com.example.cleancode.domain.model.User
import com.example.cleancode.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<Resource<List<User>>> = flow {
        try {
            emit(Resource.Loading<List<User>>())
            //fetching & mapping to convert as it is a list of data, if it is not a list then we can convert directly
            val users = repository.getUsers().map { it.toUser() }
            emit(Resource.Success<List<User>>(users))
        } catch (e: HttpException) { //related to network non-2.x.x
            emit(Resource.Error<List<User>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) { //when server cannot be reached (ex: no internet)
            emit(Resource.Error<List<User>>("Couldn't reach server, check you internet connection"))
        }
    }
}