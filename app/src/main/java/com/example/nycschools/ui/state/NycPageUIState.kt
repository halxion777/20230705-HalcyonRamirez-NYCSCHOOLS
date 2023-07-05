package com.example.nycschools.ui.state

import com.example.nycschools.repository.network.data.SchoolInformationDTO

data class NycPageListUiState(
    var schoolMap: Map<String, String> = mutableMapOf(),
    var currentSchool: SchoolInformationDTO? = null
)