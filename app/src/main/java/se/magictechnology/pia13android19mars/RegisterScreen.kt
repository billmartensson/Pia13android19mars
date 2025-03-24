package se.magictechnology.pia13android19mars

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegisterScreen(mathviewmodel : MathViewModel = viewModel()) {

    var registerName by remember { mutableStateOf("") }
    var registerPersnr by remember { mutableStateOf("") }
    var registerPassword by remember { mutableStateOf("") }
    var registerPassword2 by remember { mutableStateOf("") }
    var registerEmail by remember { mutableStateOf("") }

    val errormessage by mathviewmodel.registerErrormessage.collectAsState()

    var nicetextfield = Modifier.fillMaxWidth().padding(5.dp)

    var errortext = mapOf(
        RegisterErrors.NAME to "Ange namn",
        RegisterErrors.PERSNR to "Ange personnummer",
        RegisterErrors.PERSNRFORMAT to "Ange korrekt personnummer",
        RegisterErrors.EMAIL to "Ange e-post",
        RegisterErrors.PASSWORD to "Ange lösenord",
        RegisterErrors.PASSWORD2 to "Ange lösenord igen",
        RegisterErrors.PASSWORDMATCH to "Lösenord inte samma",
    )

    Column(modifier = Modifier.fillMaxSize().padding(5.dp)) {
        Text("REGISTRERA")

        if(errormessage.isNotEmpty()) {
            errormessage.forEach {
                Text(modifier = Modifier.fillMaxWidth().padding(5.dp).background(Color.Red).padding(5.dp),
                    color = Color.White,
                    text = errortext[it] ?: "Annat fel"
                )
            }

        }


        TextField(modifier = nicetextfield.border(5.dp, if(errormessage.contains(RegisterErrors.NAME)) Color.Red else Color.Transparent),
            label = { Text("Name") },
            value = registerName, onValueChange = { registerName = it })

        TextField(modifier = nicetextfield.border(5.dp, if(errormessage.contains(RegisterErrors.EMAIL)) Color.Red else Color.Transparent),
            label = { Text("E-post") },
            value = registerEmail, onValueChange = { registerEmail = it })

        TextField(modifier = nicetextfield.
            border(5.dp, if(errormessage.contains(RegisterErrors.PERSNR) || errormessage.contains(RegisterErrors.PERSNRFORMAT)) Color.Red else Color.Transparent),
            label = { Text("Personnummer") },
            value = registerPersnr, onValueChange = { registerPersnr = it })

        TextField(modifier = nicetextfield.border(5.dp, if(errormessage.contains(RegisterErrors.PASSWORD)) Color.Red else Color.Transparent),
            label = { Text("Lösenord") },
            value = registerPassword, onValueChange = { registerPassword = it })

        TextField(modifier = nicetextfield.border(5.dp, if(errormessage.contains(RegisterErrors.PASSWORD2)) Color.Red else Color.Transparent),
            label = { Text("Upprepa lösenord") },
            value = registerPassword2, onValueChange = { registerPassword2 = it })

        Button(onClick = {
            mathviewmodel.registeruser(registerName, registerPersnr, registerEmail, registerPassword, registerPassword2)
        }) {
            Text("Registrera")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}