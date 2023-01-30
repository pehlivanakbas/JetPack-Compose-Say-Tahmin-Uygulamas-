package com.iottech.sayitahminuygulamasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iottech.sayitahminuygulamasi.ui.theme.SayiTahminUygulamasiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayiTahminUygulamasiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SayfaGecişleri()
                }
            }
        }
    }
}

//Sayfa geçişlerini aşagıdaki yapı giib yapabiliriz
@Composable
fun SayfaGecişleri(){
val navController=rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa"){
        composable(route = "anasayfa"){
            Anasayfa(navController)
        }
        composable(route = "tahmin ekrani"){
            TahminEkrani(navController)
        }
        //geri için url tanımlar gibi / koyup sonuc yazıp tanımlarız //type gireriz
        composable(route = "sonuc_ekrani/{sonuc}",arguments= listOf(
            navArgument("sonuc"){type= NavType.BoolType}
        )){
            //it navigation daha sonra fun sonuc ekranına geç
            val sonuc=it.arguments?.getBoolean("sonuc")!!
            SonucEkrani(navController,sonuc)
        }
    }
}
@Composable
fun Anasayfa(navController: NavController) {
    //fill Max Size MAtch parent ile aynı  Space evenly kullanmak için fill max size ı mutlaka kullanmamız lazım
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
        ) {
        //Text özelligini degiştirmek için textin içine virgülle devam ettrebilirisn
        Text(text = "Tahmin Oyunu",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold)
        Image(
            painter = painterResource(id = R.drawable.zar_resim),
            contentDescription = "zar resmi"
        )
        //butona id vererek navigation yapabilirz
        Button(onClick = { navController.navigate("tahmin ekrani") },
        modifier = Modifier.size(width = 250.dp, height = 50.dp)) {
            Text(text = "Oyuna başla")

        }

    }
}
//Preview Parantexin içinde seçeneklerde showsystem ui ile emulatrode nasıl göründüğüne bakabilirz
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    SayiTahminUygulamasiTheme {
       // Anasayfa()
    }
}


