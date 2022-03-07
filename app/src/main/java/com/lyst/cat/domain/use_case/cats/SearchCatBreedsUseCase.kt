package com.lyst.cat.domain.use_case.cats

import com.lyst.cat.domain.repository.CatRepository
import com.lyst.cat.data.thecatapi.dto.Breed
import com.lyst.cat.ui.result_models.UIResultModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchCatBreedsUseCase @Inject constructor(
    private val repository: CatRepository
) {
    operator fun invoke(breed:String): Flow<UIResultModel<List<Breed>>> = flow {
        try {
            emit(UIResultModel.requesting(data = null, code = 0))
            val breeds: List<Breed> = repository.searchBreeds(breed)
            emit(UIResultModel.success(breeds, 0))
        } catch(e: HttpException) {
            emit(UIResultModel.error(message = e.localizedMessage ?: "Cat http error occurred", data=null))
        } catch(e: IOException) {
            emit(UIResultModel.error(message = "Couldn't reach cats. Visit the vet.", data=null))
        }
    }
}