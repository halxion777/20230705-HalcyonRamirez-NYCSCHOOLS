package com.example.nycschools.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschools.ui.events.NycSchooInfoScreenUIEvents
import com.example.nycschools.ui.state.NycPageListUiState
import com.example.nycschools.usecases.GetUpdatedSchoolInfoDBNUseCase
import com.example.nycschools.usecases.NYCGetAllSchoolsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedVM @Inject constructor(
    private val getUpdatedSchoolInfoDBNUseCase: GetUpdatedSchoolInfoDBNUseCase,
    private val getAllSchoolsUseCase: NYCGetAllSchoolsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(NycPageListUiState())
    val state = _state.asStateFlow()

    fun uiEvent(event: NycSchooInfoScreenUIEvents) {
        when (event) {
            is NycSchooInfoScreenUIEvents.LoadInitialData -> {
                viewModelScope.launch {
                    val allSchools = getAllSchoolsUseCase()
                    val schoolMap = allSchools.associate { it.dbn!! to it.schoolName!! }
                    _state.update {
                        it.copy(schoolMap = schoolMap, currentSchool = allSchools[0])
                    }
                }

            }

            is NycSchooInfoScreenUIEvents.GetSchoolInfoForDBN -> {
                viewModelScope.launch {
                    val updatedData = getUpdatedSchoolInfoDBNUseCase(event.dbn)
                    _state.update {
                        it.copy(currentSchool = updatedData)
                    }
                }
            }


            is NycSchooInfoScreenUIEvents.SchoolClickNavigate -> {
                event.navigate()
            }

            is NycSchooInfoScreenUIEvents.BackPressed -> {
                _state.update {
                    it.copy(currentSchool = null)
                }
            }

        }
    }
}