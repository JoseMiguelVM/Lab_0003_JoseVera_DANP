package com.omen.lab_0003

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.omen.lab_0003.ui.theme.Lab_0003Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_0003Theme {
                //Crearemos una lista donde mantendremos los objetos
                val listaUsuarios = remember { mutableStateListOf<Asistente>() }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    VerticalGradient()
                    Box(modifier =Modifier.fillMaxSize()){ //que tome el maximo de la pantalla
                        CRUD(listaUsuarios)// llamamos al compostable ScreenCRUD
                    }
                }
            }
        }
    }
}

@Composable
fun VerticalGradient(){
    val gradient = Brush.verticalGradient(
        0.0f to colorResource(id = R.color.gradiente1),
        1.0f to colorResource(id = R.color.gradiente2),
        startY = 0.0f,
        endY = 1500.0f
    )
    Box(modifier = Modifier.background(gradient))
}


@Composable
fun CRUD(listaUsuarios: MutableList<Asistente>) { //recibe una lista de usuarios Mutable
    //Definimos algunos estados
    var nombres by remember { mutableStateOf("") }
    var fechaInscripcion by remember{ mutableStateOf("") }
    var tipoSangre by remember{ mutableStateOf("") }
    var telefono by remember{ mutableStateOf("") }
    var correo by remember{ mutableStateOf("") }
    var monto by remember{ mutableStateOf("") }
    // Crearemos un estado para ver si estamos en modo edicion o no
    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar Asistente") }

    //Creamos una columna
    Column(
        modifier = Modifier
            .fillMaxWidth() //Que tome el maximo de ancho
            .fillMaxHeight() //Que tome el maximo de anlto
            .padding(12.dp)  //Que tome una separacion de 12
    ) {
        // Separamos elformulario del otro
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ) {
            //Recibira los estados el siguiente form
            Formulario(
                nombres = nombres,
                // Funcion que detectara los cambios del estado de nombre
                funNombres = { nombres = it }, //Sera igual a la funcion lambda = it
                fechaInscripcion = fechaInscripcion,
                // Funcion que detectara los cambios del estado de fechaInscripcion
                funfechaInscripcion = { fechaInscripcion = it }, //Sera igual a la funcion lambda = it
                tipoSangre = tipoSangre,
                // Funcion que detectara los cambios del estado de tipoSangre
                funtipoSangre = { tipoSangre= it }, //Sera igual a la funcion lambda = it
                telefono= telefono,
                // Funcion que detectara los cambios del estado de telefono
                funtelefono = { telefono = it }, //Sera igual a la funcion lambda = it
                correo = correo,
                // Funcion que detectara los cambios del estado de telefono
                funcorreo = { correo = it }, //Sera igual a la funcion lambda = it
                monto = monto,
                // Funcion que detectara los cambios del estado del monto
                funMonto = { monto = it }, //Sera igual a la funcion lambda = it

                // Otros items
                isEditando = isEditando,
                funIsEditando = { isEditando = false },
                textButton = textButton,
                funTextButton = { textButton = it },
                listaUsuarios = listaUsuarios,
                funResetCampos = { // Se resetea los campos del form
                    nombres = ""
                    fechaInscripcion = ""
                    tipoSangre = ""
                    telefono = ""
                    correo = ""
                    monto = ""
                }
            )
            
            Column(modifier = Modifier.fillMaxWidth()) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ){
                    // Definimos los items de lstaUsuario para que los recorra
                    items(listaUsuarios){ usuario ->
                        CardUsuario( // Es un composable
                            funNombres = { nombres = it },
                            funfechaInscripcion= { fechaInscripcion= it },
                            funtipoSangre = { tipoSangre = it },
                            funtelefono = { telefono = it },
                            funcorreo = { correo = it },
                            funMonto = { monto = it },
                            funTextButton = { textButton = it },
                            funIsEditando = { isEditando = it },
                            funBorrarUsuario = { borrarUsuario(it, listaUsuarios) },
                            // Enlistamos el objeto usuario
                            usuario = usuario
                        )
                    }
                }
            }
        }
    }
}

// Crearemos la funcion de agregar un asistente
fun agregarUsuario(nombres: String, fechaInscripcion: String, tipoSangre: String, telefono: String, correo: String, monto: String, listaUsuarios: MutableList<Asistente>) {
    listaUsuarios.add(Asistente(nombres, fechaInscripcion, tipoSangre, telefono, correo, monto))
    // Recorre la lista y muestra los elementos en el log
    for (item in listaUsuarios) {
        Log.d("Datos de Asistente", item.toString())
    }
}

// Crearemos la funcion de editar un asistente
fun editarUsuario(nombres: String, fechaInscripcion: String, tipoSangre: String, telefono: String, correo: String, monto: String, listaUsuarios: MutableList<Asistente>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.nombres == nombres) {
            usuario.fechaInscripcion = fechaInscripcion
            usuario.tipoSangre = tipoSangre
            usuario.telefono = telefono
            usuario.correo = correo
            usuario.monto = monto
        }
    }
}

fun borrarUsuario(nombres: String, listaUsuarios: MutableList<Asistente>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.nombres == nombres) {
            listaUsuarios.remove(usuario)
        }
    }
}


