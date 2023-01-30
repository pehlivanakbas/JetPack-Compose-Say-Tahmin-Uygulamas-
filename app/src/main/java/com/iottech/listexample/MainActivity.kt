package com.iottech.listexample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iottech.listexample.ui.theme.ListExampleTheme

/*
val namelist:ArrayList<String> = arrayListOf("Yusuf",
    "Zafer",
    "Osman",
    "Pehlivan",
    "Sefa Reyiz",
    "Harun Hocam") as ArrayList<String>

 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()

        }
    }

    @Composable
    fun MainScreen() {
        val greetingListState= remember { mutableStateListOf<String>("John","Amanda") }
        val newnameStateContent= remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {



            GreetingList(greetingListState,
            { greetingListState.add(newnameStateContent.value) },
                newnameStateContent.value,
                { newName ->  newnameStateContent.value =newName})
        }
    }

    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun GreetingList(nameslist:List<String>,
                     buttonClick: ()->Unit,
                     textfieldvalue:String,
                        textfieldUpdate:(newName:String)->Unit) {

        for (name in nameslist) {
            Greeting(name = name)
        }

        //newnamestatecontent diye değişken tanımlarız textfielda
        // yazdıkca value degeri degişir ve ne yazdıgını hatırlar.

        TextField(value =textfieldvalue,
            onValueChange = textfieldUpdate
        )
        Button(onClick = buttonClick ) {
            Text(text = "Add a new name")

        }

    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello ${name}",
            style = MaterialTheme.typography.h4)
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
            MainScreen()
        }
    }
