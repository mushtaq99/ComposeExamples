package com.tb.composeexamples.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tb.composeexamples.models.Quote

@Composable
fun QuoteListItem(quote:Quote,onClick:(quote:Quote)->Unit){
   Card(modifier = Modifier.padding(8.dp)
       .clickable { onClick(quote) },
       elevation = CardDefaults.cardElevation(
           defaultElevation = 6.dp
       ),) {
       Row(modifier = Modifier.padding(16.dp)) {
        Image(imageVector = Icons.Filled.FormatQuote,
            contentDescription ="Image" ,
            colorFilter = ColorFilter.tint(Color.White),
            alignment = Alignment.TopStart,
            modifier = Modifier
                .size(40.dp)
                .rotate(180F)
                .background(Color.Black),
            )
           Spacer(modifier = Modifier.padding(4.dp))
           Column(modifier = Modifier.weight(1f)) {
               Text(text = quote.text,
                   style = MaterialTheme.typography.headlineSmall,
                   modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp))
               Box(modifier = Modifier
                   .fillMaxWidth(.4f)
                   .background(Color(0xFFEEEEEE))
                   .height(1.dp))

               Text(text = quote.author,
                   style = MaterialTheme.typography.headlineSmall,
                   fontWeight = FontWeight.Thin,
                   modifier = Modifier.padding(4.dp))

           }

       }

   }
}

