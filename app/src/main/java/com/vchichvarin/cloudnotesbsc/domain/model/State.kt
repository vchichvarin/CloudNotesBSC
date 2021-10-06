package com.vchichvarin.cloudnotesbsc.domain.model

sealed class State() {
    object Success : State()
    object Error: State()
    object Loading: State()
    object Waiting: State()
}
