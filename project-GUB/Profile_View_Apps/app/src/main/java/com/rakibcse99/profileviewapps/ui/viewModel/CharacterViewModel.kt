package com.rakibcse99.profileviewapps.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakibcse99.profileviewapps.base.ErrorResponse
import com.rakibcse99.profileviewapps.base.Resource
import com.rakibcse99.profileviewapps.repository.model.CharacterModel
import com.rakibcse99.profileviewapps.repository.model.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(val repository: CharacterRepository) : ViewModel(){

    private var _characterModelResult =
        MutableSharedFlow<Resource<MutableList<CharacterModel>, ErrorResponse>>()
    var characterModelResult: SharedFlow<Resource<MutableList<CharacterModel>, ErrorResponse>> =
        _characterModelResult

    fun getCharacter() = viewModelScope.launch {
        _characterModelResult.emit(Resource.loading(null))
        _characterModelResult.emit(repository.getCharacter())
    }

}


