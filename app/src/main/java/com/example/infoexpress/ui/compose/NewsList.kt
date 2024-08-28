package com.example.infoexpress.ui.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.infoexpress.data.Article

@Composable
fun NewsLayout() {
    val newsList = dummyNewsList()
    LazyColumn {
        items(newsList) {
            ArticleItem(it)
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
