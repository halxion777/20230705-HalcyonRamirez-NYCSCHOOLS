package com.example.nycschools.vm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschools.repository.network.data.SchoolInformationDTO
import com.example.nycschools.ui.events.NycSchooInfoScreenUIEvents
import com.example.nycschools.usecases.GetUpdatedSchoolInfoDBNUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed class SchoolInformationUIEvent {
    data class GetSchoolInformationDBN(val dbn: String): SchoolInformationUIEvent()
}


@HiltViewModel
class SchoolInformationVM @Inject constructor(private val getUpdatedSchoolInfoDBNUseCase: GetUpdatedSchoolInfoDBNUseCase) :
    ViewModel() {

        private val _state = mutableStateOf(SchoolInformationDTO())
        val state: State<SchoolInformationDTO> = _state

        fun uiEvent(event: SchoolInformationUIEvent) {
            when(event) {
                is SchoolInformationUIEvent.GetSchoolInformationDBN -> {
                    viewModelScope.launch {
                        val data = getUpdatedSchoolInfoDBNUseCase(event.dbn)
                        _state.value = data
                    }
                }
             }
        }
}