package com.example.nycschools.ui.events

sealed class NycSchooInfoScreenUIEvents {
    data class SchoolClickNavigate(val navigate: () -> Unit): NycSchooInfoScreenUIEvents()
    data class GetSchoolInfoForDBN(val dbn: String): NycSchooInfoScreenUIEvents()
    object LoadInitialData: NycSchooInfoScreenUIEvents()
    object BackPressed: NycSchooInfoScreenUIEvents()

}
