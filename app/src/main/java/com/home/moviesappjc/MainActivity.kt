package com.home.moviesappjc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.home.moviesappjc.ui.navigation.HomeScreenResponsive
import com.home.moviesappjc.ui.navigation.Play
import com.home.moviesappjc.ui.theme.ColorBackground
import com.home.moviesappjc.ui.theme.ItemMenuSelected
import com.home.moviesappjc.ui.theme.ItemMenuUnSelected

class MainActivity : ComponentActivity() {
    private lateinit var bottomBarVisible: MutableState<Boolean>
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val navController = rememberNavController()
                bottomBarVisible = rememberSaveable { mutableStateOf(true) }

                Scaffold(
                    containerColor = ColorBackground,
                    bottomBar = {
                        AnimatedVisibility(
                            visible = bottomBarVisible.value
                        ) {
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
                bottomBarVisible.value = true
                HomeScreenResponsive(navController)
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
                bottomBarVisible.value = false
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
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.forEachIndexed { index, item ->
                    val selected = item.route == backStackEntry.value?.destination?.route
                    if (index == 1) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(if (selected) ItemMenuSelected else ItemMenuUnSelected)
                                .padding(8.dp)
                                .clickable {
                                    onClick(item)
                                }
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
                            tint = if (selected) ItemMenuSelected else ItemMenuUnSelected,
                            modifier = Modifier
                                .size(32.dp)
                                .clickable {
                                    onClick(item)
                                }
                        )
                    }
                }
            }
        }
    }
}
