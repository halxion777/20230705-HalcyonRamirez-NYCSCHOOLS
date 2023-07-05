package com.example.nycschools.ui.components.SchoolInformation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Fax
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Web
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nycschools.R
import com.example.nycschools.repository.network.data.SchoolInformationDTO


@Composable
fun ContactInformation(
    modifier: Modifier = Modifier,
    schoolEmail: String,
    phoneNumber: String,
    website: String,
    faxNumber: String,
) {

    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.contact_information),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        if (schoolEmail.isNotEmpty()) {
            ContactInfoItem(icon = Icons.Rounded.Email, text = schoolEmail)
        }
        if (phoneNumber.isNotEmpty()) {
            ContactInfoItem(icon = Icons.Rounded.Phone, text = phoneNumber)
        }
        if (website.isNotEmpty()) {
            ContactInfoItem(icon = Icons.Rounded.Web, text = website)
        }
        if (faxNumber.isNotEmpty()) {
            ContactInfoItem(icon = Icons.Rounded.Fax, text = faxNumber)
        }
    }
}


@Composable
fun ContactInfoItem(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(top = 5.dp)) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 10.dp)
        )
        Text(text = text)
    }
}