package com.example.productwithapi.domain.model

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.productwithapi.persentation.ui.CustomListItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomList(list: List<CustomListItem>) {
    LazyColumn() {
        items(list){
            ListItem(
                headlineText = { Text(text=it.title) },
                supportingText = { Text(text=it.description )}
            )
            Spacer(modifier = Modifier.height(20.dp))

        }


    }
}