package com.vchichvarin.cloudnotesbsc.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vchichvarin.cloudnotesbsc.data.interfaces.SaveRepository
import com.vchichvarin.cloudnotesbsc.domain.model.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val saveRepository: SaveRepository
) : ViewModel() {

    val infoState = MutableLiveData<State>()

    fun saveNote(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveRepository.saveNote(text)
                .catch { it.printStackTrace() }
                .collect {
                    when (it) {
                        is State.Loading -> {
                            infoState.postValue(it)
                        }
                        is State.Success -> {
                            infoState.postValue(it)
                        }
                    }
                }
        }
    }


}