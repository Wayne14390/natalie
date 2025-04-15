package com.example.natalie.ui.theme.screens.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.natalie.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    var selectedItem = remember { mutableStateOf(0) }
    Scaffold(
        bottomBar = { NavigationBar(containerColor = Color.Green,){
            NavigationBarItem(
                selected = selectedItem.value == 0,
                onClick = {selectedItem.value = 0},
                icon = { Icon(Icons.Filled.Email, contentDescription = "Email") },
                label = { Text(text = "Email") },
                alwaysShowLabel = true
            )
            NavigationBarItem(
                selected = selectedItem.value == 1,
                onClick = {selectedItem.value = 1},
                icon = { Icon(Icons.Filled.Share, contentDescription = "Share") },
                label = { Text(text = "Share") },
                alwaysShowLabel = true
            )
            NavigationBarItem(
                selected = selectedItem.value == 2,
                onClick = {selectedItem.value = 2},
                icon = { Icon(Icons.Filled.Phone, contentDescription = "Phone") },
                label = { Text(text = "Phone") },
                alwaysShowLabel = true
            )
        } }
    )
    { innerPadding ->
        Box() {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "background image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(innerPadding)
            )

        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(
                title = { Text(text = "Chat Conmigo") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Profile"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Green,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color.Blue
                )
            )
            Row {
                Card(
                    modifier = Modifier.padding(10.dp).clickable {
                    },
                    shape = RoundedCornerShape(20.dp,),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(Color.LightGray)
                )
                {
                    Box(
                        modifier = Modifier.height(100.dp)
                            .padding(25.dp),
                        contentAlignment = Alignment.Center
                    )
                    { Text(text = "Students", color = Color.Black) }
                }
                Card(
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(20.dp,),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(Color.LightGray)
                )
                {
                    Box(
                        modifier = Modifier.height(100.dp).padding(25.dp),
                        contentAlignment = Alignment.Center
                    )
                    { Text(text = "Teachers", color = Color.Black) }
                }
                Card(
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(20.dp,),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(Color.LightGray)
                )
                {
                    Box(
                        modifier = Modifier.height(100.dp)
                            .padding(25.dp),
                        contentAlignment = Alignment.Center
                    )
                    { Text(text = "Staff Members", color = Color.Black) }
                }

            }
            Row {
                Card(
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(20.dp,),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(Color.LightGray)
                )
                {
                    Box(
                        modifier = Modifier.height(100.dp)
                            .padding(25.dp),
                        contentAlignment = Alignment.Center
                    )
                    { Text(text = "Classes", color = Color.Black) }
                }
                Card(
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(20.dp,),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(Color.LightGray)
                )
                {
                    Box(
                        modifier = Modifier.height(100.dp).padding(25.dp),
                        contentAlignment = Alignment.Center
                    )
                    { Text(text = "Occassion", color = Color.Black) }
                }
                Card(
                    modifier = Modifier.padding(10.dp),
                    shape = RoundedCornerShape(20.dp,),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(Color.LightGray)
                )
                {
                    Box(
                        modifier = Modifier.height(100.dp)
                            .padding(25.dp),
                        contentAlignment = Alignment.Center
                    )
                    { Text(text = "Exams", color = Color.Black
                    ) }
                }

            }

        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}