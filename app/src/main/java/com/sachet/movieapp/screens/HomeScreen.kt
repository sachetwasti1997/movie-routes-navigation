package com.sachet.movieapp.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sachet.movieapp.navigation.MovieScreen

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Blue,
                elevation = 20.dp,
                modifier = Modifier.height(55.dp)
            ) {
                Text(text = "Movies")
            }
        }
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
    "Avatar",
    "365 days",
    "50 Shades of Grey",
    "Krishh",
    "Krishh2",
    "Bahubali",
    "Naruto",
    "Naruto Shippuden"
)){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(movieList) {
                MovieRow(movie = it){ movie ->
                    navController.navigate(route = MovieScreen.DetailsScreen.name+"/$movie")
                }
            }
        }
    }
}

@Composable
fun MovieRow(movie: String, onItemClick: (String) -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .height(100.dp)
            .clickable {
                onItemClick(movie)
            },
        elevation = 10.dp,
        shape = RoundedCornerShape(CornerSize(10.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RoundedCornerShape(CornerSize(4.dp))
            ) {
                Icon(imageVector = Icons.Default.AccountBox,
                    contentDescription = "Movie Image")
            }
            Text(color = Color.Magenta,fontWeight = FontWeight.ExtraBold,text = movie)
        }
    }
}