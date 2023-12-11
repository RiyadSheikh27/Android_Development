package com.rakibcse99.profileviewapps.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakibcse99.profileviewapps.base.ErrorResponse
import com.rakibcse99.profileviewapps.base.Resource
import com.rakibcse99.profileviewapps.repository.model.CharacterRepository
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




    private var _addstudentModelResult =
        MutableSharedFlow<Resource<StudentModelItem, ErrorResponse>>()
    var addStudentModelResult: SharedFlow<Resource<StudentModelItem, ErrorResponse>> =
        _addstudentModelResult

    fun addStudent(studentModelItem: StudentModelItem) = viewModelScope.launch {
        _addstudentModelResult.emit(Resource.loading(null))
        _addstudentModelResult.emit(repository.addtStudent(studentModelItem))
    }
}


