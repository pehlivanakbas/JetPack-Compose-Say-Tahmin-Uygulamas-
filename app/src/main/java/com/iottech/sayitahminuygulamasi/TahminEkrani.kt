package com.iottech.sayitahminuygulamasi

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlin.random.Random

@Composable
fun TahminEkrani(navController: NavHostController) {
//String türünden bir değişkeni bu şekilde tanımlarız
    val textfieldTahmin= remember {
        mutableStateOf("")
    }
    val kalanHak= remember {
        mutableStateOf(value = 5)
    }
    val yonlendirme= remember {
        mutableStateOf(value = "")
    }
    val rastgelesayı= remember {
        mutableStateOf(value = 5)
    }
LaunchedEffect(key1 = true){
    rastgelesayı.value= Random.nextInt(101) //0-100 arası bir sayı üretecek
    Log.e("rastgele sayı:",rastgelesayı.value.toString()) //kaç oldugunu görebilmek için

}

    //fill Max Size MAtch parent ile aynı  Space evenly kullanmak için fill max size ı mutlaka kullanmamız lazım
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        //Text özelligini degiştirmek için textin içine virgülle devam ettrebilirisn
        Text(text = "Kalan Hak :${kalanHak.value }",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
             color = Color.Red
        )
        Text(text = "Yardım: ${yonlendirme.value}",
            fontSize = 24.sp,

        )

        //textfieldin içine veri yazacagımız zaman aşağıdaki şekilde tanımlarız
        //label hint ile aynıdır

        TextField(
            value = textfieldTahmin.value,
            onValueChange = { textfieldTahmin.value = it},
            label = {Text(text = "Tahmin ")}
        )

        Button(onClick = {

             kalanHak.value-=1

            val  tahmin=textfieldTahmin.value.toInt()
            if(tahmin==rastgelesayı.value){
                navController.navigate("sonuc_ekrani/true") {
                    //geri gelmek için
                    popUpTo("tahmin ekrani") { inclusive = true }
                }
            return@Button //eger dogruysa alt kısmın calısmasını da engeller

            }
            if(tahmin>rastgelesayı.value){
                yonlendirme.value="Azalt"
            }
            if(tahmin<rastgelesayı.value){
                yonlendirme.value="Arttır"
            }
            if(kalanHak.value==0){
                yonlendirme.value="Arttır"

                navController.navigate("sonuc_ekrani/false") {
                    //geri gelmek için
                    popUpTo("tahmin ekrani") { inclusive = true }
                }
            }
            textfieldTahmin.value="" //böyle yaparak textfield içindeki veriyi temizleriz yoksa kendimiz silmek zorunda kalırız



        }  ,modifier = Modifier.size(width = 250.dp, height = 50.dp)) {
            Text(text = "TAHMİN ET")

        }

    }
}