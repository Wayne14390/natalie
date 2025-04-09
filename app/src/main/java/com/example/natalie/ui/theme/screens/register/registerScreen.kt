package com.example.natalie.ui.theme.screens.register


import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.natalie.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController){
    var firstname by remember { mutableStateOf(value = "") }
    var lastname by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }

    Column (modifier = Modifier.fillMaxHeight().fillMaxWidth()){
        TopAppBar(
            title = { Text(text = "") },
            navigationIcon = { IconButton(onClick = {})
            { Icon(imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrowback") } },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                navigationIconContentColor = Color.Blue,
                titleContentColor = Color.Black,
                actionIconContentColor = Color.Blue
            )
        )
        Text(text = "Sign Up",
            fontSize = 30.sp,
            color = Color.Blue,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Sign up into your account",
            fontSize = 15.sp,
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Image(painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .height(100.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = firstname,
            onValueChange = {newFirstName -> firstname = newFirstName},
            label = { Text(text = "Enter first name") },
            placeholder = { Text(text = "Please enter firstname") },
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally),
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Name") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = lastname,
            onValueChange = {newLastName -> lastname=newLastName},
            label = { Text(text = "Enter Last Name") },
            placeholder = { Text(text = "Please enter lastname") },
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally),
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Name") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {newEmail -> email = newEmail},
            label = { Text(text = "Enter your email") },
            placeholder = { Text(text = "Please enter email") },
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally),
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {newPassword -> password =newPassword},
            label = { Text(text = "Enter your password") },
            placeholder = { Text(text = "Please enter password") },
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") }
            )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {},
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally).width(250.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue)) { Text(text = "Sign Up") }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = buildAnnotatedString { append("If already registered, Login here") }, modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally)        .clickable {
        })

    }

}
@Preview(showBackground = true , showSystemUi = true)
@Composable
fun RegisterScreenPreview(){
    RegisterScreen(rememberNavController())
}
