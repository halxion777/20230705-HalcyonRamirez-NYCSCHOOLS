package com.example.nycschools.ui.components.SchoolList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nycschools.R

@Composable
fun SchoolList(
    schoolMap: List<Pair<String, String>>,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val schools = schoolMap.toList()
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.schools),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        )
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .drawBehind {
                drawLine(
                    Color.LightGray,
                    Offset(size.width, 0f),
                    Offset(size.width, size.height),
                    strokeWidth = 20f
                )
            }
            .padding(10.dp)) {
            items(schools.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Text(text = "${index + 1}.")
                    Text(
                        text = schools[index].second,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {
                                onClick(schools[index].first)
                            })
                }

            }
        }
    }
}