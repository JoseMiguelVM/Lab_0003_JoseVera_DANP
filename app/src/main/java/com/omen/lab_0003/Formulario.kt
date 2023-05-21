package com.omen.lab_0003

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Formulario(
    // Se definen los campos que estamos utilizando
    nombres: String,
    funNombres: (String) -> Unit,
    fechaInscripcion: String,
    funfechaInscripcion: (String) -> Unit,
    tipoSangre: String,
    funtipoSangre: (String) -> Unit,
    telefono: String,
    funtelefono: (String) -> Unit,
    correo: String,
    funcorreo: (String) -> Unit,
    monto: String,
    funMonto: (String) -> Unit,

    isEditando: Boolean,
    funIsEditando: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,
    listaUsuarios: MutableList<Asistente>,
    funResetCampos: () -> Unit
){
    // Nos pide el valor y que tiene que hacer cuando cambie el valor del OutlinedTextField en NOMBRE
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombres,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text), // Tipo de teclado que se desea
        singleLine = true,// Que sea de una sola linea
        maxLines = 1, // Maximo de linea deseada
        onValueChange = { funNombres(it) },
        label = {Text(text ="Nombres Completos")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black, // Color de texto
            disabledTextColor = Color.Gray, // Cuando no se este editando
            cursorColor = Color.Black, // Color del cursor
            focusedBorderColor = Color.Blue, // Color de edicion del edittext
            unfocusedBorderColor = Color.Black // Cuando no se encuentra en edicion el campo
        ),
        //PARA NO PODER EDITAR ESTE APARTADO EN LOS REGISTROS YA QUE UN NOMBRE NO ES EDITABLE
        enabled = !isEditando // Cuando estemos editando no se quiere que sea modificable este campo
    )
    Spacer(modifier = Modifier.padding(vertical = 3.dp))

    // Nos pide el valor y que tiene que hacer cuando cambie el valor del OutlinedTextField en FECHA INSCRIPCION
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = fechaInscripcion,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text), // Tipo de teclado que se desea
        singleLine = true,// Que sea de una sola linea
        maxLines = 1, // Maximo de linea deseada
        onValueChange = { funfechaInscripcion(it) },
        label = {Text(text ="Fecha de Inscripcion")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black, // Color de texto
            disabledTextColor = Color.Gray, // Cuando no se este editando
            cursorColor = Color.Black, // Color del cursor
            focusedBorderColor = Color.Blue, // Color de edicion del edittext
            unfocusedBorderColor = Color.Black // Cuando no se encuentra en edicion el campo
        ),
    )
    Spacer(modifier = Modifier.padding(vertical = 3.dp))

    // Nos pide el valor y que tiene que hacer cuando cambie el valor del OutlinedTextField en FECHA INSCRIPCION
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = tipoSangre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text), // Tipo de teclado que se desea
        singleLine = true,// Que sea de una sola linea
        maxLines = 1, // Maximo de linea deseada
        onValueChange = { funtipoSangre(it) },
        label = {Text(text ="Tipo de Sangre")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black, // Color de texto
            disabledTextColor = Color.Gray, // Cuando no se este editando
            cursorColor = Color.Black, // Color del cursor
            focusedBorderColor = Color.Blue, // Color de edicion del edittext
            unfocusedBorderColor = Color.Black // Cuando no se encuentra en edicion el campo
        ),
    )
    Spacer(modifier = Modifier.padding(vertical = 3.dp))

    // Nos pide el valor y que tiene que hacer cuando cambie el valor del OutlinedTextField en FECHA INSCRIPCION
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = telefono,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text), // Tipo de teclado que se desea
        singleLine = true,// Que sea de una sola linea
        maxLines = 1, // Maximo de linea deseada
        onValueChange = { funtelefono(it) },
        label = {Text(text ="Telefono")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black, // Color de texto
            disabledTextColor = Color.Gray, // Cuando no se este editando
            cursorColor = Color.Black, // Color del cursor
            focusedBorderColor = Color.Blue, // Color de edicion del edittext
            unfocusedBorderColor = Color.Black // Cuando no se encuentra en edicion el campo
        ),
    )
    Spacer(modifier = Modifier.padding(vertical = 3.dp))

    // Nos pide el valor y que tiene que hacer cuando cambie el valor del OutlinedTextField en FECHA INSCRIPCION
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = correo,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text), // Tipo de teclado que se desea
        singleLine = true,// Que sea de una sola linea
        maxLines = 1, // Maximo de linea deseada
        onValueChange = { funcorreo(it) },
        label = {Text(text ="Correo")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black, // Color de texto
            disabledTextColor = Color.Gray, // Cuando no se este editando
            cursorColor = Color.Black, // Color del cursor
            focusedBorderColor = Color.Blue, // Color de edicion del edittext
            unfocusedBorderColor = Color.Black // Cuando no se encuentra en edicion el campo
        ),
    )
    Spacer(modifier = Modifier.padding(vertical = 3.dp))

    // Nos pide el valor y que tiene que hacer cuando cambie el valor del OutlinedTextField en FECHA INSCRIPCION
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = monto,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text), // Tipo de teclado que se desea
        singleLine = true,// Que sea de una sola linea
        maxLines = 1, // Maximo de linea deseada
        onValueChange = { funMonto(it) },
        label = {Text(text ="Monto Pagado")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black, // Color de texto
            disabledTextColor = Color.Gray, // Cuando no se este editando
            cursorColor = Color.Black, // Color del cursor
            focusedBorderColor = Color.Blue, // Color de edicion del edittext
            unfocusedBorderColor = Color.Black // Cuando no se encuentra en edicion el campo
        ),
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Definimos el boton
    Button(
        modifier = Modifier.width(220.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.orange)),
        onClick = {
            if (isEditando) { //Si nuestro estado "editando" es true entonces
                editarUsuario(nombres, fechaInscripcion, tipoSangre, telefono, correo, monto, listaUsuarios) // se llama a esta funcion
                funTextButton("Agregar Asistente")
                funIsEditando() // Cambiamos el estado

            } else {  //Si nuestro estado "editando" es false entonces
                agregarUsuario(nombres, fechaInscripcion, tipoSangre, telefono, correo, monto, listaUsuarios)
            }
            funResetCampos()
        }
    ) {
        Text(
            color = Color.White,
            text = textButton
        )
    }
}