package com.vchichvarin.cloudnotesbsc.data.interfaces

import com.vchichvarin.cloudnotesbsc.domain.model.State
import kotlinx.coroutines.flow.Flow

interface SaveRepository {

    fun saveNote(text: String) : Flow<State?>

}