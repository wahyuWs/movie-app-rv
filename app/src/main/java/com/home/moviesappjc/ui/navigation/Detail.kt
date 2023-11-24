package com.home.moviesappjc.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.home.moviesappjc.R
import com.home.moviesappjc.ui.model.Movie
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
        ReleaseDateAndGenreSection(fontFamily = lattoFamily)
        DescriptionSection(
            fontFamily = lattoFamily,
            description = "Rey (Daisy Ridley) finally manages to find the legendary Jedi knight, Luke Skywalker (Mark Hamill) on an island with a magical aura. The heroes of The Force Awakens including Leia, Finn. \"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\""
        )
        RelatedMovieSection(
            fontFamily = lattoFamily,
            items = listOf(
                Movie(
                    image = R.drawable.star_wars_the_rise_of_skywalker_2019,
                    title = "Star Wars: The Rise of Skywalker",
                    year = "(2019)"
                ),
                Movie(
                    image = R.drawable.star_wars_the_force_awakens_2015,
                    title = "Star Wars: The Force Awakens",
                    year = "(2015)"
                ),
                Movie(
                    image = R.drawable.rogue_one_a_star_wars_story_2016,
                    title = "Rogue One: A Star Wars Story",
                    year = "(2016)"
                ),
            )
        )
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

@Composable
fun ReleaseDateAndGenreSection(fontFamily: FontFamily) {
    Row(
        modifier = Modifier
            .padding(start = 24.dp, top = 16.dp, end = 24.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Release date",
            fontFamily = fontFamily,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .padding(end = 56.dp)
        )
        Text(
            text = "Genre",
            fontFamily = fontFamily,
            fontSize = 16.sp,
            color = Color.White
        )
    }
    Row(
        modifier = Modifier
            .padding(start = 24.dp, top = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "December 9, 2017",
            fontFamily = fontFamily,
            fontSize = 12.sp,
            color = TextColorDetail,
            modifier = Modifier
                .padding(end = 45.dp)
        )
        Box(
            modifier = Modifier
                .padding(end = 12.dp)
                .border(1.dp, Color.DarkGray, RoundedCornerShape(4.dp))
                .clip(RoundedCornerShape(4.dp))
                .wrapContentSize()
                .background(BoxBackground)
                .padding(top = 4.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = "Action",
                fontFamily = fontFamily,
                fontSize = 12.sp,
                color = BoxTextColor
            )
        }
        Box(
            modifier = Modifier
                .border(1.dp, Color.DarkGray, RoundedCornerShape(4.dp))
                .clip(RoundedCornerShape(4.dp))
                .wrapContentSize()
                .background(BoxBackground)
                .padding(top = 4.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = "Sci-Fi",
                fontFamily = fontFamily,
                fontSize = 12.sp,
                color = BoxTextColor
            )
        }
    }
    Spacer(modifier = Modifier.height(15.dp))
    Divider(
        color = Color.DarkGray,
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}

@Composable
fun DescriptionSection(fontFamily: FontFamily, description: String) {
    Text(
        text = "Synopsis",
        fontFamily = fontFamily,
        fontSize = 16.sp,
        color = Color.White,
        modifier = Modifier
            .padding(start = 24.dp, top = 16.dp, bottom = 12.dp)
    )
    var expandedText by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        if (expandedText) {
            Text(
                text = description,
                fontFamily = fontFamily,
                fontSize = 12.sp,
                color = TextColorDetail
            )
            Text(
                text = "Read less..",
                fontFamily = fontFamily,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .clickable { expandedText = false }
            )
        } else {
            Text(
                text = if (description.length > 185) {
                    description.substring(0, 185)
                } else {
                    description
                },
                fontFamily = fontFamily,
                fontSize = 12.sp,
                color = TextColorDetail
            )
            Text(
                text = "Read more..",
                fontFamily = fontFamily,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .clickable { expandedText = true }
            )
        }
    }
}

@Composable
fun RelatedMovieSection(fontFamily: FontFamily, items: List<Movie>) {
    Text(
        text = "Related Movies",
        fontFamily = fontFamily,
        fontSize = 16.sp,
        color = Color.White,
        modifier = Modifier
            .padding(start = 24.dp, top = 20.dp, bottom = 16.dp)
    )
    LazyRow(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, bottom = 29.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        items(items) { item ->
            ItemRelatedMovie(item = item, fontFamily = fontFamily)
        }
    }
}

@Composable
fun ItemRelatedMovie(item: Movie, fontFamily: FontFamily) {
    Column(
        modifier = Modifier
            .padding(end = 16.dp)
            .width(142.dp)
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth()
                .height(106.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        //menggabungkan text title dan year
        val title = buildAnnotatedString {
            withStyle(style = SpanStyle(Color.White)) {
                append(item.title)
            }
            append(" ")
            withStyle(style = SpanStyle(TextColorDetail)) {
                append(item.year)
            }
        }
        Text(
            text = title,
            fontFamily = fontFamily,
            fontSize = 12.sp,
            color = Color.White
        )
    }
}
