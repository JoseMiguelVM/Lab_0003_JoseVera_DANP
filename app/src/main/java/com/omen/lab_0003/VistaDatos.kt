package com.omen.lab_0003

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun CardUsuario(
    funNombres : (String) -> Unit,
    funfechaInscripcion : (String) -> Unit,
    funtipoSangre : (String) -> Unit,
    funtelefono : (String) -> Unit,
    funcorreo : (String) -> Unit,
    funMonto : (String) -> Unit,
    funTextButton : (String) -> Unit,
    funIsEditando : (Boolean) -> Unit,
    funBorrarUsuario : (String) -> Unit,
    // Enlistamos el objeto usuario
    usuario : Asistente
) {
    Card( // Creamos el card
        modifier = Modifier.fillMaxWidth() // Toma el maximo del ancho
            .padding(vertical = 8.dp).background(Color.LightGray),
        elevation = 8.dp
    ) {
        // Para agrupar los elementos a mostrar y los demas no seran visibles, solo se veran por consola
        Column( modifier = Modifier .fillMaxSize().padding(9.dp), Arrangement.Center) {
            Text(text = usuario.nombres, modifier = Modifier.align(Alignment.CenterHorizontally))
            //Text(text = usuario.fechaInscripcion, modifier = Modifier.align(Alignment.CenterHorizontally))
            //Text(text = usuario.tipoSangre, modifier = Modifier.align(Alignment.CenterHorizontally))
            //Text(text = usuario.telefono, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = usuario.correo, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = usuario.monto, modifier = Modifier.align(Alignment.CenterHorizontally))

            Row( modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.verde)),
                    onClick = { //Para el evento
                        funNombres(usuario.nombres)
                        funfechaInscripcion(usuario.fechaInscripcion)
                        funtipoSangre(usuario.tipoSangre)
                        funtelefono(usuario.telefono)
                        funcorreo(usuario.correo)
                        funMonto(usuario.monto)
                        funTextButton("Editar Usuario")
                        funIsEditando(true)
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Editar"
                    )
                }
                Button(
                    modifier = Modifier.padding(horizontal = 4.dp).weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {
                        funBorrarUsuario(usuario.nombres)
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Borrar"
                    )
                }
            }
        }
    }
}