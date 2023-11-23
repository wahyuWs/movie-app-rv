package com.home.moviesappjc.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.home.moviesappjc.R
import com.home.moviesappjc.ui.theme.BoxBackground
import com.home.moviesappjc.ui.theme.BoxTextColor
import com.home.moviesappjc.ui.theme.ColorBackground
import com.home.moviesappjc.ui.theme.TextColorDetail

@Composable
fun Detail() {
}

@Preview(device = "id:pixel_5")
@Composable
fun PreviewDetail() {
    val lattoFamily =  FontFamily(
        Font(R.font.lato, FontWeight.Normal)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorBackground)
    ) {
        MediaPlayerSection()
        TitleAndDetailSection(fontFamily = lattoFamily)
    }
}

@Composable
fun MediaPlayerSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(287.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.star_war_full),
            contentDescription = "Media Player",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.icon_play_detail),
            contentDescription = "Play Button",
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.Center)
        )
        Icon(
            imageVector = Icons.Filled.KeyboardArrowLeft,
            contentDescription = "Back Button",
            tint = Color.White,
            modifier = Modifier
                .padding(start = 22.dp, top = 28.dp)
                .width(80.dp)
                .height(50.dp)
                .align(Alignment.TopStart)
        )
    }
}

@Composable
fun TitleAndDetailSection(fontFamily: FontFamily) {
    Row(
        modifier = Modifier
            .padding(start = 24.dp, top = 24.dp, end = 24.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Star Wars: The Last Jedi",
            fontFamily = fontFamily,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .padding(end = 8.dp)
        )
        Box(
            modifier = Modifier
                .border(1.dp, Color.DarkGray, RoundedCornerShape(4.dp))
                .clip(RoundedCornerShape(4.dp))
                .wrapContentSize()
                .background(BoxBackground)
                .padding(top = 4.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = "4K",
                fontFamily = fontFamily,
                fontSize = 12.sp,
                color = BoxTextColor
            )
        }
    }
    Row(
        modifier = Modifier
            .padding(start = 24.dp, top = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.time_icon),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 6.dp)
                .size(10.dp)
        )
        Text(
            text = "152 minutes",
            fontFamily = fontFamily,
            fontSize = 12.sp,
            color = TextColorDetail,
            modifier = Modifier
                .padding(end = 12.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.star_grey_icon),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 6.dp)
                .size(10.dp)
        )
        Text(
            text = "7.0 (IMDb)",
            fontFamily = fontFamily,
            fontSize = 12.sp,
            color = TextColorDetail
        )
    }
    Spacer(modifier = Modifier.height(15.dp))
    Divider(
        color = Color.DarkGray,
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}
