package com.example.nycschools.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschools.ui.events.NycSchooInfoScreenUIEvents
import com.example.nycschools.ui.state.NycPageListUiState
import com.example.nycschools.usecases.NYCGetAllSchoolsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolListVM @Inject constructor(
    private val getAllSchoolsUseCase: NYCGetAllSchoolsUseCase
) : ViewModel() {

    private var _state = mutableStateOf(NycPageListUiState())
    val state: State<NycPageListUiState> = _state
    fun uiEvent(event: NycSchooInfoScreenUIEvents) {
        when (event) {
            is NycSchooInfoScreenUIEvents.SchoolClickNavigate -> {
                event.navigate()
            }
            is NycSchooInfoScreenUIEvents.LoadInitialData -> {
                viewModelScope.launch {
                    val allSchools = getAllSchoolsUseCase()
                    val schoolMap = allSchools.associateBy({ it.dbn!! }, { it.schoolName!! })
                    _state.value = _state.value.copy(schoolMap = schoolMap)
                }

            }
            else -> {}
        }
    }

}