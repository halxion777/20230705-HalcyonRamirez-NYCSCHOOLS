package com.example.nycschools.ui.components.SchoolInformation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.nycschools.R

@Composable
fun SatScores(
    mathScore: String,
    readingScore: String,
    writingScore: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = stringResource(R.string.sat_scores), fontWeight = FontWeight.Bold, fontSize = 30.sp)
        SatScore(label = stringResource(R.string.math_score), text = mathScore)
        SatScore(label = stringResource(R.string.reading_score), text = readingScore)
        SatScore(label = stringResource(R.string.writingscore), text = writingScore)
    }
}

@Composable
fun SatScore(label: String, text: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Text(text = label)
        Text(text = text, fontWeight = FontWeight.SemiBold)
    }
}