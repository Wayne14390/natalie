package com.example.natalie.ui.theme.screens.students

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.natalie.R

@Composable
fun AddstudentScreen(navController: NavController){
    var  name by remember { mutableStateOf( "") }
    var  gender by remember { mutableStateOf( "") }
    var  course by remember { mutableStateOf( "") }
    var  description by remember { mutableStateOf( "") }
    val imageUri = rememberSaveable() { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent())
    {uri: Uri? -> uri?.let { imageUri.value=it } }
    Box() {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "background image",
            contentScale = ContentScale.FillBounds
        )
    }
    Column(modifier = Modifier.fillMaxSize().padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.fillMaxWidth().background(Color.Green).padding(20.dp)) {
            Text(text = "ADD NEW STUDENT",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Card(shape = CircleShape,
            modifier = Modifier.padding(10.dp).size(200.dp)) {
            AsyncImage(model = imageUri.value ?: R.drawable.ic_person,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(200.dp).clickable { launcher.launch("image/*") })
        }
        Text(text = "Upload your picture")

        OutlinedTextField(value = name,
            onValueChange = {newName->name=newName},
            label = { Text(text = "Enter Name") },
            placeholder = { Text(text = "Please enter name") },
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = gender,
            onValueChange = {newGender->gender=newGender},
            label = { Text(text = "Enter Gender") },
            placeholder = { Text(text = "Please enter gender") },
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = course,
            onValueChange = {newCourse->course=newCourse},
            label = { Text(text = "Enter Course") },
            placeholder = { Text(text = "Please enter course") },
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = description,
            onValueChange = {newDescription->description=newDescription  },
            label = { Text(text = "Enter Description") },
            placeholder = { Text(text = "Please enter description") },
            modifier = Modifier.fillMaxWidth().height(150.dp),
            singleLine = false)
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {}, modifier = Modifier.wrapContentWidth(), colors = ButtonDefaults.buttonColors(
                Color.Black)) { Text(text = "Dashboard") }
            Button(onClick = {}, modifier = Modifier.wrapContentWidth(), colors = ButtonDefaults.buttonColors(
                Color.Green)) { Text(text = "Save") }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddstudentScreenPreview(){
    AddstudentScreen(rememberNavController())
}
