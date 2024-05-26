package com.tb.composeexamples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun Preview() {

LazyColumn(content = {
    items(getCategoryList()){ item: Category ->
        BlogCategory(image = item.image, title = item.title , subtitle =item.subtitle )
    }
})

}


@Composable
fun BlogCategory(image: Int, title: String, subtitle: String) {

    Card(modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Start",
                modifier = Modifier
                    .size(64.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ContentDescription(title, subtitle,Modifier.weight(.8f))
        }

    }


}

@Composable
private fun ContentDescription(title: String, subtitle: String,modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        Text(
            text = subtitle,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Thin
        )

    }
}

data class Category(val image:Int,val title:String,val subtitle: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.user,"Kotlin","Android Developer"))
    list.add(Category(R.drawable.user,"Swift","IOS Developer"))
    list.add(Category(R.drawable.user,"Java","Android Developer"))
    list.add(Category(R.drawable.user,"JavaScript","Web Developer"))
    list.add(Category(R.drawable.user,"C++","Micro Services Developer"))
    list.add(Category(R.drawable.user,"Kotlin","Android Developer"))
    list.add(Category(R.drawable.user,"Swift","IOS Developer"))
    list.add(Category(R.drawable.user,"Java","Android Developer"))
    list.add(Category(R.drawable.user,"JavaScript","Web Developer"))
    list.add(Category(R.drawable.user,"C++","Micro Services Developer"))
    list.add(Category(R.drawable.user,"JavaScript","Web Developer"))
    list.add(Category(R.drawable.user,"C++","Micro Services Developer"))
    list.add(Category(R.drawable.user,"Kotlin","Android Developer"))
    list.add(Category(R.drawable.user,"Swift","IOS Developer"))
    list.add(Category(R.drawable.user,"Java","Android Developer"))
    list.add(Category(R.drawable.user,"JavaScript","Web Developer"))
    list.add(Category(R.drawable.user,"C++","Micro Services Developer"))
    return list

}