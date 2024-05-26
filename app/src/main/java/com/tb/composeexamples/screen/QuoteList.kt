package com.tb.composeexamples.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tb.composeexamples.models.Quote

@Composable
fun QuoteList(data:Array<Quote>,onclick:(quote:Quote)->Unit) {
    LazyColumn {
        items(data){
            QuoteListItem(quote = it,onclick)

        }
    }
    
}