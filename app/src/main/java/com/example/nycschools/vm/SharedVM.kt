package com.example.nycschools.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschools.ui.events.NycSchooInfoScreenUIEvents
import com.example.nycschools.ui.state.NycPageListUiState
import com.example.nycschools.usecases.GetUpdatedSchoolInfoDBNUseCase
import com.example.nycschools.usecases.NYCGetAllSchoolsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedVM @Inject constructor(
    private val getUpdatedSchoolInfoDBNUseCase: GetUpdatedSchoolInfoDBNUseCase,
    private val getAllSchoolsUseCase: NYCGetAllSchoolsUseCase,
    private val savedState: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(NycPageListUiState())
    val state: State<NycPageListUiState> = _state
    fun uiEvent(event: NycSchooInfoScreenUIEvents) {
        when (event) {
            is NycSchooInfoScreenUIEvents.LoadInitialData -> {
                viewModelScope.launch {
                    val allSchools = getAllSchoolsUseCase()
                    val schoolMap = allSchools.associate { it.dbn!! to it.schoolName!! }
                    _state.value =
                        _state.value.copy(schoolMap = schoolMap, currentSchool = allSchools[0])
                }

            }
            is NycSchooInfoScreenUIEvents.SchoolClickDbn -> {
                viewModelScope.launch {
                    val updatedData = getUpdatedSchoolInfoDBNUseCase(event.dbn)
                    _state.value = _state.value.copy(currentSchool = updatedData)
                }
            }
            else -> {}
        }
    }
}