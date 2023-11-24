package com.home.moviesappjc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.home.moviesappjc.ui.model.BottomItem
import com.home.moviesappjc.ui.navigation.Detail
import com.home.moviesappjc.ui.navigation.HomeScreen
import com.home.moviesappjc.ui.navigation.Play
import com.home.moviesappjc.ui.theme.ColorBackground
import com.home.moviesappjc.ui.theme.ItemMenuSelected
import com.home.moviesappjc.ui.theme.ItemMenuUnSelected
import com.home.moviesappjc.ui.theme.Linear
import com.home.moviesappjc.ui.theme.MoviesAppJcTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomSection(
                            items = listOf(
                                BottomItem(
                                    R.drawable.home_page_icon,
                                    "home"
                                ),
                                BottomItem(
                                    R.drawable.play_page_icon,
                                    "play"
                                ),
                                BottomItem(
                                    R.drawable.profile_page_icon,
                                    "profile"
                                ),
                            ),
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth(),
                            navController = navController,
                            onClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }

    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeScreen(navController)
            }
            composable("play") {
                Play()
            }
            composable("profile") {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(ColorBackground),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Not finished yet",
                        color = Color.White,
                        fontSize = 22.sp
                    )
                }
            }
            composable("DetailScreen") {
                Detail()
            }
        }
    }

    @Composable()
    fun BottomSection(
        items: List<BottomItem>,
        modifier: Modifier,
        navController: NavController,
        onClick: (BottomItem) -> Unit
    ){
        val backStackEntry = navController.currentBackStackEntryAsState()
        NavigationBar(
           modifier = modifier,
            containerColor = ColorBackground,
            tonalElevation = 4.dp,
            contentColor = Color.Transparent
        ) {
            items.forEachIndexed { index, item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                NavigationBarItem(
                    selected = selected,
                    onClick = { onClick(item) },
                    icon = {
                        if (index == 1) {
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(38.dp)
                                    .background(ItemMenuUnSelected)
                            ) {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(14.dp)
                                        .align(Alignment.Center)
                                )
                            }
                        } else {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(32.dp)
                            )
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = ItemMenuSelected,
                        unselectedIconColor = ItemMenuUnSelected,
                        indicatorColor = ColorBackground
                    )
                )
            }

        }
    }
}
