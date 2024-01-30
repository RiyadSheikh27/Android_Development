package com.rakibcse99.profileviewapps.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakibcse99.profileviewapps.base.ErrorResponse
import com.rakibcse99.profileviewapps.base.Resource
import com.rakibcse99.profileviewapps.repository.model.CharacterRepository
import com.rakibcse99.profileviewapps.repository.model.DataResponse
import com.rakibcse99.profileviewapps.repository.model.StudentDto
import com.rakibcse99.profileviewapps.repository.model.StudentModelItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(val repository: CharacterRepository) : ViewModel(){


    private var _studentModelResult =
        MutableSharedFlow<Resource<MutableList<StudentModelItem>, ErrorResponse>>()
    var studentModelResult: SharedFlow<Resource<MutableList<StudentModelItem>, ErrorResponse>> =
        _studentModelResult

    fun getStudent() = viewModelScope.launch {
        _studentModelResult.emit(Resource.loading(null))
        _studentModelResult.emit(repository.getStudent())
    }




    private var _dataResponseModelResult =
        MutableSharedFlow<Resource<DataResponse, ErrorResponse>>()
    var dataResponseModelResult: SharedFlow<Resource<DataResponse, ErrorResponse>> =
        _dataResponseModelResult

    fun addStudent(studentModelItem: StudentDto) = viewModelScope.launch {
        _dataResponseModelResult.emit(Resource.loading(null))
        _dataResponseModelResult.emit(repository.addStudent(studentModelItem))
    }
    fun updateStudent(studentModelItem: StudentModelItem) = viewModelScope.launch {
        _dataResponseModelResult.emit(Resource.loading(null))
        _dataResponseModelResult.emit(repository.updateStudent(studentModelItem))
    }

    fun delete(id: String)  = viewModelScope.launch {
        _dataResponseModelResult.emit(Resource.loading(null))
        _dataResponseModelResult.emit(repository.delete(id))
    }
}


