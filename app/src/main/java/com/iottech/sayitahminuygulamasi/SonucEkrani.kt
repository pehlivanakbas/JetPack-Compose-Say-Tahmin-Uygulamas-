package com.iottech.sayitahminuygulamasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SonucEkrani(navController: NavHostController,gelenSonuc:Boolean) {
    //fill Max Size MAtch parent ile aynı  Space evenly kullanmak için fill max size ı mutlaka kullanmamız lazım
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        if (gelenSonuc == true) {
            //Text özelligini degiştirmek için textin içine virgülle devam ettrebilirisn
            Text(
                text = "KAZANDINIZ",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.mutlu_resim),
                contentDescription = "kazandınız  resmi"
            )
        }
        else {
            Text(
                text = "KAYBETTİNİZ",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.uzgun_resim),
                contentDescription = "kaybettiniz  resmi"
            )
        }

    }

}
