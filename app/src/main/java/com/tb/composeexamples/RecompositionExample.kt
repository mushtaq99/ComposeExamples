package com.tb.composeexamples

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class RecompositionExample {


    @Preview
    @Composable
    fun CallScreen(){
        var count = rememberSaveable{
            mutableStateOf(0);
        }
        SentNotification(count.value ,{ count.value++ })
        MessageBar(count.value);

    }


    @Composable
    fun SentNotification(count: Int, increment: () -> Int){
        // the main Recomposition work through mutableStateof
        //the issue with the remember is that it remember but rotate not working
      /*  var count = remember {
            mutableStateOf(0);
        }*/

        // rememberSaveable actually store the value in bundle
    /*    var count = rememberSaveable{
            mutableStateOf(0);
        }*/
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
            ) {
            Text(text = "Your hava sent ${count}")
            Button(onClick = {
                increment()
                Log.d("######", "Button pressed: ")
            }) {
                Text(text = "Send Notification")

            }
        }

    }
    
    @Composable
    fun MessageBar(messages:Int){
       Card(){
           Row(modifier = Modifier.padding(8.dp).fillMaxWidth(),
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.Center
           ) {
               
               Image(imageVector = Icons.Outlined.Favorite, contentDescription ="empty" , modifier = Modifier.padding(4.dp))
               Text(text = "Messages Sent so for $messages")

           }

       }
    }
}