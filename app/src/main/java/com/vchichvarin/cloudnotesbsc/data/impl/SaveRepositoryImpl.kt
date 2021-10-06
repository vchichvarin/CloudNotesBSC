package com.vchichvarin.cloudnotesbsc.data.impl

import com.vchichvarin.cloudnotesbsc.data.interfaces.SaveRepository
import com.vchichvarin.cloudnotesbsc.domain.model.State
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SaveRepositoryImpl @Inject constructor(

) : SaveRepository {

    override fun saveNote(text: String) = flow {
        emit(State.Loading)
        delay(3000)
        emit(State.Success)
    }

}