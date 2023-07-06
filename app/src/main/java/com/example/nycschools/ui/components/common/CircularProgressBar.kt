package com.example.nycschools.ui.components.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.nycschools.R

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    @StringRes text: Int = R.string.fetching_data
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp),
            color = Color.Blue,
            strokeWidth = 5.dp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(id = text))
    }
}