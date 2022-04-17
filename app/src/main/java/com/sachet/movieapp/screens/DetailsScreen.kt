package com.sachet.movieapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DetailsScreen(movie: String?, navController: NavHostController){
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Blue,
                elevation = 20.dp,
                modifier = Modifier.height(55.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(modifier = Modifier
                        .size(30.dp)
                        .clickable { navController.popBackStack() },
                        color = Color.Blue
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Arrow")
                    }
                    Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
                        if (movie != null) {
                            Text(text = movie)
                        }
                    }
                }
            }
        }
    ) {
        Card(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            elevation = 15.dp
        ) {
            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier.size(200.dp),
                    shape = RoundedCornerShape(CornerSize(10.dp))
                ) {
                    Icon(imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Movie Image")
                }
                if (movie != null) {
                    Text(style = TextStyle(
                        color = Color.Magenta,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 39.sp
                    ),
                        text = movie)
                }
            }
        }
    }
}