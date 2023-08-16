package com.example.productwithapi

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomList(list: List<CustomListItem>) {
    LazyColumn() {
        items(list) {
            ListItem(
                headlineText = { Text(text = "test") }, supportingText = { Text(text = "test1") }
            )
        }
    }
}