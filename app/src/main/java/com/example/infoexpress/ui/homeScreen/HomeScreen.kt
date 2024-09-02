package com.example.infoexpress.ui.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.infoexpress.data.database.entity.Article
import com.example.infoexpress.ui.compose.NewsLayout
import com.example.infoexpress.ui.theme.InfoExpressTheme

@Composable
fun HomeScreen() {
    InfoExpressTheme {
        Surface {
            Column (
                modifier = Modifier.fillMaxSize().padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                NewsLayout(dummyNewsList())
            }
        }
    }
}


// News List for test purpose
fun dummyNewsList() = listOf(
    Article(
        "Ned Stark perde a cabeça",
        "Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia ",
        "https://cdn.ome.lt/o1SYfKk6WxQOsgaugF4fEC7ZmHo=/570x0/smart/uploads/conteudo/fotos/NED-STARK.jpg"
    ),
    Article(
        "Arya consegue fugir das maõs de Cercei",
        "Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia ",
        "https://ninfacrocodilo.com.br/wp-content/uploads/2022/08/Arya-Azor-Ahai-1024x576.webp"
    ),
    Article(
        "Rob se torna lorde de Winterfall após morte de seu pai",
        "Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia ",
        "https://upload.wikimedia.org/wikipedia/pt/c/ce/Robb_Stark-Richard_Madden.jpg"
    ),
    Article(
        "Tio Ben desaparecido por mais de dois meses",
        "Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia ",
        "https://p2.trrsf.com/image/fget/cf/1200/900/middle/images.terra.com/2017/12/20/5989130.jpg"
    ),
    Article(
        "Khal Drogo não resiste a ferimento grave e falece nos braços de sua amada",
        "Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia ",
        "https://jasonmomoabrasilfaclub.wordpress.com/wp-content/uploads/2015/03/drogo-morrendo.jpg"
    ),
    Article(
        "Khaleesi perde seu bebê de estresse emocional após perda de seu marido",
        "Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia Este é o conteudo da noticia ",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJ8Q8Ov2rxIgqWlYTYgzR1RFiEguSX4k43EA&s"
    )
)
