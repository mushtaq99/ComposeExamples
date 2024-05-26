package com.tb.composeexamples

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tb.composeexamples.screen.QuoteDetails
import com.tb.composeexamples.screen.QuoteListScreen
import com.tb.composeexamples.ui.theme.ComposeExamplesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch{
            delay(10000)
            DataManager.loadAssetFromFile(applicationContext)

        }
        setContent {
            App()
            //BlogCategory(R.drawable.user, "Android", "Android Developer")
            //ModiferExxample()
            /*Column {
                Listview(R.drawable.user,"Jhone","Kotlin Developer")
                Listview(R.drawable.user,"Jhone","Swift Developer")
                Listview(R.drawable.user,"Jhone","Java Developer")
                Listview(R.drawable.user,"Jhone","JavaScript Developer")
                Listview(R.drawable.user,"Jhone","C++ Developer")


            }*/
        }
    }
}


@Composable
fun App() {
    if(DataManager.isDataLoaded.value){
        if(DataManager.currenPage.value == Pages.LISTING){
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPage(it)

            }
        } else{
            DataManager.currentQuote?.let { QuoteDetails(quote = it) }
        }

    }else{
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)){
            Text(text = "Loading......",
                style = MaterialTheme.typography.bodyLarge)
        }
    }
    
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun DisPlayMessage(name:String,modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = name,
            style = TextStyle(color = Color.Black,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 34.sp,
                textAlign = TextAlign.Center,

            ),
            modifier = modifier
        )
        Text(text = "Welcome to Jetpack",
            style = TextStyle(color = Color.Red),
            modifier = modifier
        )
        Image(painter = painterResource(id = android.R.drawable.star_on),
            contentDescription = "testing image",
            colorFilter = ColorFilter.tint(Color.Red))

        Button(onClick = { Log.d("######", "DisPlayMessage: ") }) {
            Text(text = "Submit")
            Image(painter = painterResource(id = android.R.drawable.btn_plus),
                contentDescription = "button",
                colorFilter = ColorFilter.tint(Color.White))

            
        }


    }

}
@Composable
fun TextINput(name:String){
    val state = remember {
        mutableStateOf("")
    }
    TextField(value = state.value,
        onValueChange = {
            state.value = it
            Log.d("#####", "Input field click:$it ")},
        placeholder = {},
        label = { Text(text = "Enter $name")})
}

@Composable
fun Listview(image:Int,name:String,occupation:String){
    Row(Modifier.padding(8.dp)) {
        Image(painter = painterResource(id = image), contentDescription = "Start",Modifier.size(40.dp))
        Column {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text(text = occupation, fontWeight = FontWeight.Thin, fontSize = 12.sp)

        }
    }
}

@Preview(showBackground = true, name = "Hello Message", showSystemUi = true, widthDp = 200, heightDp = 200)
@Composable
fun GreetingPreview() {
    ComposeExamplesTheme {
        //Greeting("Android")
        DisPlayMessage("Mushtaq")
    }
}

@Composable
fun ModiferExxample(){
    Text(text = "Mushtaq",
        color = Color.White,
        fontSize = 22.sp,
        modifier = Modifier
            .size(400.dp)
            .padding(20.dp)
            .background(color = Color.Red)

           )
}
enum class Pages{
    LISTING,
    DETAIL
}