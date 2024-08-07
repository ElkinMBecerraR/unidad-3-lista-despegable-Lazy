package com.elkin.appcuadricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elkin.appcuadricula.data.DataSource
import com.elkin.appcuadricula.model.Temas
import com.elkin.appcuadricula.ui.theme.AppCuadriculaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCuadriculaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Cuadricula(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Cuadricula(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(DataSource.listaTemas) { temas ->
            CardTareas(temas)
        }
    }
}

@Composable
fun CardTareas(temas: Temas, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(start = 10.dp, end = 10.dp)) {
        Row {
            Box {
                Image(
                    painterResource(id = temas.imagen),
                    contentDescription = null,
                    modifier = modifier.size(width = 68.dp, height = 68.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column() {
                Text(
                    text = stringResource(temas.nombre),
                    modifier = modifier.padding(16.dp, 16.dp, 16.dp, 4.dp),
                    fontStyle = FontStyle.Italic,
                    fontSize = 14.sp
                )

                Row(modifier = modifier.padding(16.dp, 0.dp, 0.dp, 0.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        text = temas.cantidad.toString(),
                        modifier = modifier.padding(start = 8.dp)
                    )
                }

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppCuadriculaTheme {
        Cuadricula()
    }
}