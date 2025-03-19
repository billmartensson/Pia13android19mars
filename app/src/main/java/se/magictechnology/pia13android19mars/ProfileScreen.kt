package se.magictechnology.pia13android19mars

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {

    var addshoptitle by remember { mutableStateOf("") }
    var addshopamount by remember { mutableStateOf("") }

    var errormessage by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize()) {
        Text("PROFILE")

        if(errormessage != "") {
            Text(modifier = Modifier.testTag("errortext"), text = errormessage)
        }

        Row {
            TextField(modifier = Modifier.testTag("titletextfield").weight(1f).padding(5.dp), value = addshoptitle, onValueChange = { addshoptitle = it })
            TextField(modifier = Modifier.testTag("amounttextfield").width(50.dp).padding(5.dp), value = addshopamount, onValueChange = { addshopamount = it })

        }

        Button(modifier = Modifier.testTag("addbutton"), onClick = {
            errormessage = ""

            if(addshopamount == "") {
                errormessage = "Enter amount!"
            }
            if(addshoptitle == "") {
                errormessage = "Enter title!"
            }
        }) {
            Text("ADD SHOP")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}