package com.tb.composeexamples

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.tb.composeexamples.models.Quote

object DataManager {
    var data = emptyArray<Quote>()
    var currenPage = mutableStateOf(Pages.LISTING)
    var currentQuote:Quote? = null;
    var isDataLoaded = mutableStateOf(false);
    fun loadAssetFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size:Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value = true

    }
    fun switchPage(quote: Quote?) {
        if(currenPage.value == Pages.LISTING){
            currenPage.value = Pages.DETAIL
            currentQuote = quote

        }else{
            currenPage.value = Pages.LISTING
        }
    }


}