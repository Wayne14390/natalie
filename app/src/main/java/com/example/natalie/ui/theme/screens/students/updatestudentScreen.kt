package com.example.natalie.ui.theme.screens.students

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.natalie.R
import com.example.natalie.data.AuthViewModel
import com.example.natalie.data.StudentViewModel
import com.example.natalie.models.StudentModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdatestudentScreen(navController: NavController,studentId: String){
    val imageUri = rememberSaveable { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? -> uri?.let { imageUri.value=it } }
    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var nationality by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }
    val studentViewModel: StudentViewModel= viewModel()
    val authViewModel: AuthViewModel = viewModel()
    val context= LocalContext.current
    val currentDataRef  = FirebaseDatabase.getInstance()
        .getReference().child("Students/$studentId")

    DisposableEffect(Unit){
        val listener = object  : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val student = snapshot.getValue(StudentModel::class.java)
                student?.let {
                    name = it.name
                    gender = it.gender
                    nationality = it.nationality
                    course = it.course
                    desc = it.desc
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,error.message,Toast.LENGTH_LONG).show()
            }
        }
        currentDataRef.addValueEventListener(listener)
        onDispose { currentDataRef.removeEventListener(listener) }
    }
    Column (modifier = Modifier.padding(10.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        TopAppBar(
            title = { Text(text = "") },
            navigationIcon = {
                IconButton(onClick = {
                    authViewModel.handleBackClick(navController,context)
                })
                { Icon(imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Arrowback") } },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                navigationIconContentColor = Color.Green,
                titleContentColor = Color.Black,
                actionIconContentColor = Color.Green
            )
        )
        Box(modifier = Modifier.fillMaxWidth()
            .background(Color.Red).padding(16.dp)){ Text(text = "UPDATE STUDENT",
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()) }
        Card(shape = CircleShape, modifier = Modifier.padding(10.dp).size(200.dp)) {
            AsyncImage(model = imageUri.value ?: R.drawable.ic_person,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(200.dp)
                    .clickable { launcher.launch("image/*") })
        }
        Text(text = "Upload Picture Here")

        OutlinedTextField(value = name,
            onValueChange = {newName->name=newName},
            label = { Text(text = "Enter student name") },
            placeholder = { Text(text = "PLease enter student name") },
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = gender,
            onValueChange = {newGender->gender=newGender},
            label = { Text(text = "Enter student gender") },
            placeholder = { Text(text = "PLease enter student gender") },
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = nationality,
            onValueChange = {newNationality->nationality=newNationality},
            label = { Text(text = "Enter Nationality") },
            placeholder = { Text(text = "Please enter nationality") },
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = course,
            onValueChange = {newCourse->course=newCourse},
            label = { Text(text = "Enter student course") },
            placeholder = { Text(text = "PLease enter student course") },
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = desc,
            onValueChange = {newDesc->desc=newDesc},
            label = { Text(text = "Enter student description") },
            placeholder = { Text(text = "PLease enter student description") },
            modifier = Modifier.fillMaxWidth().height(150.dp), singleLine = false)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /*TODO: Handle Go Back*/ }) {
                Text(text = "GO BACK")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = {
                val studentRepository = StudentViewModel()
                studentRepository.updateStudent(
                    context = context,
                    navController = navController,
                    name = name,
                    gender = gender,
                    nationality = nationality,
                    course = course,
                    desc = desc,
                    studentId = studentId
                )
            }) {
                Text(text = "UPDATE")
            }
        }
    }
}