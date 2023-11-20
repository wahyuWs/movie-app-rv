package com.home.moviesappjc.ui.navigation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.home.moviesappjc.R
import com.home.moviesappjc.ui.model.Movie
import com.home.moviesappjc.ui.theme.ColorBackground
import com.home.moviesappjc.ui.theme.CustomTransparent
import com.home.moviesappjc.ui.theme.Linear
import com.smarttoolfactory.animatedlist.AnimatedInfiniteLazyRow
import com.smarttoolfactory.animatedlist.model.AnimationProgress
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {
    val lattoFamily =  FontFamily(
        Font(R.font.lato, FontWeight.Normal)
    )

    Column(
        modifier = Modifier
            .background(ColorBackground)
            .fillMaxSize()
    ){
        TitleSection(lattoFamily)
        PlayingSection(lattoFamily)
        TrendingSection(
            items = listOf(
                Movie(
                    R.drawable.home_1,
                    "Avengers: Endgame",
                    8.4
                ),
                Movie(
                    R.drawable.home_2,
                    "Star Wars: The Last Jedi",
                    7.0
                ),
                Movie(
                    R.drawable.home_3,
                    "Tenet",
                    7.6
                ),
                Movie(
                    R.drawable.home_4,
                    "Wonder Woman 1984",
                    7.6
                ),
            )
            , lattoFamily
        )
    }
}

@Preview(device = "spec:width=1080px,height=2340px,dpi=360", showSystemUi = true)
@Composable
fun PrevieDesign(){
    val lattoFamily =  FontFamily(
        Font(R.font.lato, FontWeight.Normal)
    )

    Column(
        modifier = Modifier
            .background(ColorBackground)
            .fillMaxSize()
    ){
        TitleSection(lattoFamily)
        PlayingSection(lattoFamily)
        TrendingSection(
            items = listOf(
                Movie(
                    R.drawable.home_1,
                    "Avengers: Endgame",
                    8.4
                ),
                Movie(
                    R.drawable.home_2,
                    "Star Wars: The Last Jedi",
                    7.0
                ),
                Movie(
                    R.drawable.home_3,
                    "Tenet",
                    7.6
                ),
                Movie(
                    R.drawable.home_4,
                    "Wonder Woman 1984",
                    7.6
                ),
            )
            , lattoFamily
        )
    }
}

@Composable
fun TitleSection(fontFamily: FontFamily){
    Row(
        modifier = Modifier
            .padding(start = 24.dp, top = 44.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Stream",
            fontSize = 24.sp,
            fontFamily = fontFamily,
            color = Linear,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = "Everywhere",
            fontSize = 24.sp,
            fontFamily = fontFamily,
            color = Color.White
        )
    }
}

@Composable
fun PlayingSection(fontFamily: FontFamily){
    Box(
        modifier = Modifier
            .padding(top = 28.dp, start = 24.dp, end = 24.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner_play),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        )
        Row(
            modifier = Modifier
                .padding(start = 14.dp, bottom = 14.dp)
                .align(Alignment.BottomStart)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(colorResource(id = R.color.white_transparant))
                .padding(horizontal = 20.dp, vertical = 16.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_play),
                contentDescription = "play now",
                modifier = Modifier
                    .size(42.dp)
                    .padding(end = 12.dp)
            )
            Column {
                Text(
                    text = "Continue Watching",
                    fontSize = 12.sp,
                    fontFamily = fontFamily,
                    color = colorResource(id = R.color.grey_light)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Ready Player one",
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun TrendingSection(items: List<Movie>, fontFamily: FontFamily){
    Column(
        modifier = Modifier
            .padding(top = 36.dp, start = 24.dp)
    ) {
        Text(
            text = "Trending",
            fontSize = 24.sp,
            fontFamily = fontFamily,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(24.dp))
        AnimatedInfiniteLazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            items = items,
            activeItemWidth = 330.dp,
            inactiveItemWidth = 270.dp,
            visibleItemCount = 2,
            spaceBetweenItems = 8.dp
        ) {animationProgress, index, item, size, lazyListState ->
            ItemListTrending(movie = item, fontFamily = fontFamily, size, animationProgress, lazyListState)
        }
    }
}

@Composable
fun ItemListTrending(movie: Movie, fontFamily: FontFamily, size: Dp, animationProgress: AnimationProgress, lazyListState: LazyListState) {
    val coroutineScope = rememberCoroutineScope()
    val scale = animationProgress.scale

    Box(modifier = Modifier
        .fillMaxWidth()
        .width(size)
        .height(380.dp)
        .clip(RoundedCornerShape(30.dp))
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
            alpha = scale
        }
        .clickable(
            interactionSource = remember {
                MutableInteractionSource()
            },
            indication = null
        ) {
            coroutineScope.launch {
                lazyListState.animateScrollBy(animationProgress.distanceToSelector)
            }
        }
    ){
        Image(
            painter = painterResource(id = movie.image),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(30.dp))
        )
        Row(
            modifier = Modifier
                .padding(18.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(colorResource(id = R.color.white_transparant))
                .padding(14.dp)
                .align(Alignment.TopEnd)
        ){
            Column {
                Text(
                    text = "IMDb",
                    fontFamily = fontFamily,
                    fontSize = 8.sp,
                    color = Color.White
                )
                Image(
                    painter = painterResource(id = R.drawable.icon_star),
                    contentDescription = "Icon Rate",
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(
                text = movie.rate.toString(),
                fontSize = 16.sp,
                fontFamily = fontFamily,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Row(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .align(Alignment.BottomCenter)
                .background(colorResource(id = R.color.white_transparant)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = movie.title,
                fontSize = 16.sp,
                fontFamily = fontFamily,
                color = Color.White,
                modifier = Modifier
                    .padding(33.dp)
            )
        }
    }
}