package com.home.moviesappjc

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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.home.moviesappjc.ui.navigation.HomeScreen
import com.home.moviesappjc.ui.theme.ColorBackground
import com.home.moviesappjc.ui.theme.ItemMenuSelected
import com.home.moviesappjc.ui.theme.ItemMenuUnSelected
import com.home.moviesappjc.ui.theme.Linear
import com.home.moviesappjc.ui.theme.MoviesAppJcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppJcTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    HomeScreen()
                    BottomSection(
                        items = listOf(
                            R.drawable.home_page_icon,
                            R.drawable.play_page_icon,
                            R.drawable.profile_page_icon
                        ),
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .padding(vertical = 18.dp)
                    )
                }
            }
        }
    }

    @Preview(device = "spec:width=1080px,height=1920px,dpi=320")
    @Composable()
    fun PreviewMainActivity(){
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            HomeScreen()
            BottomSection(
                items = listOf(
                    R.drawable.home_page_icon,
                    R.drawable.play_page_icon,
                    R.drawable.profile_page_icon
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(vertical = 18.dp)
            )
        }
    }

    @Composable()
    fun BottomSection(items: List<Int>, modifier: Modifier){
        var selectedItemIndex by remember {
            mutableStateOf(0)
        }
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                if (index == 1) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(color = if (index == selectedItemIndex) ItemMenuSelected else ItemMenuUnSelected)
                            .padding(14.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = item),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(18.dp)
                                .clickable {
                                    selectedItemIndex = index
                                }
                        )
                    }
                } else {
                    Icon(
                        painter = painterResource(id = item),
                        contentDescription = null,
                        tint = if (index == selectedItemIndex) ItemMenuSelected else ItemMenuUnSelected,
                        modifier = Modifier
                            .size(32.dp)
                            .clickable {
                                selectedItemIndex = index
                            }
                    )
                }
            }
        }
    }
}
