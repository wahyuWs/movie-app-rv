package com.home.moviesappjc.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.home.moviesappjc.R
import com.home.moviesappjc.ui.model.Movie
import com.home.moviesappjc.ui.theme.ColorBackground
import com.home.moviesappjc.ui.theme.Linear
import com.home.moviesappjc.ui.theme.SearchColor
import com.home.moviesappjc.ui.theme.TextColorDetail
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Play() {
    val lattoFamily =  FontFamily(
        Font(R.font.lato, FontWeight.Normal)
    )
    val itemsTab = listOf(
        "Movies", "Tv Series", "Documentary", "Sports"
    )
    val pagerState = rememberPagerState(pageCount = itemsTab.size)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorBackground)
    ) {
        TitleSection1(fontFamily = lattoFamily)
        SearchBar()
        TabSection(
            items = itemsTab,
            pagerState = pagerState,
            fontFamily = lattoFamily
        )
        TabContent(
            pagerState = pagerState,
            itemsMovie = listOf(
                Movie(
                    image = R.drawable.soul,
                    title = "Soul",
                    year = "(2020)",
                    width = 154.dp,
                    height = 250.dp
                ),
                Movie(
                    image = R.drawable.knives_out_2019,
                    title = "Knives Out",
                    year = "(2019)",
                    width = 154.dp,
                    height = 200.dp
                ),
                Movie(
                    image = R.drawable.mulan_2020,
                    title = "Mulan",
                    year = "(2020)",
                    width = 154.dp,
                    height = 250.dp
                ),
                Movie(
                    image = R.drawable.onward_2020,
                    title = "Onward",
                    year = "(2020)",
                    width = 154.dp,
                    height = 200.dp
                ),
                Movie(
                    image = R.drawable.birds_of_prey_2020,
                    title = "Birds of Prey",
                    year = "(2020)",
                    width = 154.dp,
                    height = 250.dp
                ),
                Movie(
                    image = R.drawable.now_you_see_me2_2016,
                    title = "Now You See Me 2",
                    year = "(2016)",
                    width = 154.dp,
                    height = 200.dp
                )
            ),
            itemsSeries = listOf(
                Movie(
                    image = R.drawable.stranger_things,
                    title = "Stranger Things",
                    width = 154.dp,
                    height = 250.dp
                ),
                Movie(
                    image = R.drawable.the_flash,
                    title = "The Flash",
                    width = 154.dp,
                    height = 200.dp
                ),
                Movie(
                    image = R.drawable.doctor_who,
                    title = "Doctor Who",
                    width = 154.dp,
                    height = 250.dp
                ),
                Movie(
                    image = R.drawable.money_heist,
                    title = "Money Heist",
                    width = 154.dp,
                    height = 200.dp
                ),
                Movie(
                    image = R.drawable.breaking_bad,
                    title = "Breaking Bad",
                    width = 154.dp,
                    height = 250.dp
                ),
                Movie(
                    image = R.drawable.sherlock,
                    title = "Sherlock",
                    width = 154.dp,
                    height = 200.dp
                )
            ),
            fontFamily = lattoFamily
        )
    }
}

@Composable
fun TitleSection1(fontFamily: FontFamily) {
    Text(
        text = "Find Movies, Tv series, and more..",
        fontSize = 24.sp,
        fontFamily = fontFamily,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp, start = 24.dp, end = 74.dp, bottom = 20.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = "Sherlock Holmes") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = Color.White,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = SearchColor,
            textColor = Color.Gray,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable()
fun TabSection(items: List<String>, pagerState: PagerState, fontFamily: FontFamily) {
    val scope = rememberCoroutineScope()
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 0.dp,
        indicator = {
            TabRowDefaults.Indicator(
                modifier = Modifier
                    .pagerTabIndicatorOffset(
                        pagerState = pagerState,
                        tabPositions = it
                    ),
                height = 2.dp,
                color = Linear
            )
        },
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .padding(start = 24.dp)
            .fillMaxWidth()
    ) {
        items.forEachIndexed { index, item ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = item,
                        fontSize = 16.sp,
                        fontFamily = fontFamily,
                        color = if (pagerState.currentPage == index) Linear else Color.White
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(pagerState: PagerState, itemsMovie: List<Movie>, itemsSeries: List<Movie>, fontFamily: FontFamily) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 80.dp)
            .fillMaxWidth()
    ) { index ->
        when (index) {
            0 -> {
                ListMovie(items = itemsMovie, fontFamily = fontFamily)
            }
            1 -> {
                ListSeries(items = itemsSeries, fontFamily = fontFamily)
            }
            2 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Not finished yet",
                        color = Color.White,
                        fontFamily = fontFamily,
                        fontSize = 22.sp
                    )
                }
            }
            3 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Not finished yet",
                        color = Color.White,
                        fontFamily = fontFamily,
                        fontSize = 22.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ListMovie(items: List<Movie>, fontFamily: FontFamily) {
    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxSize(),
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        verticalItemSpacing = 18.dp
    ){
        items(items) {item ->
            Column{
                val modifier = if ((item.width != null) && (item.height != null)){
                    Modifier
                        .fillMaxWidth()
                        .height(item.height!!)
                }else {
                    Modifier.fillMaxSize()
                }
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = item.title,
                    contentScale = ContentScale.FillBounds,
                    modifier = modifier
                        .padding(bottom = 8.dp)
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
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    color = Color.White,
                    modifier = Modifier.padding(end = 4.dp)
                )
            }
        }
    }
}

@Composable
fun ListSeries(items: List<Movie>, fontFamily: FontFamily) {
    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxSize(),
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        verticalItemSpacing = 18.dp
    ){
        items(items) {item ->
            Column {
                val modifier = if ((item.width != null) && (item.height != null)){
                    Modifier
                        .fillMaxWidth()
                        .height(item.height!!)
                }else {
                    Modifier.fillMaxSize()
                }
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = item.title,
                    contentScale = ContentScale.FillBounds,
                    modifier = modifier
                        .padding(bottom = 8.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                Text(
                    text = item.title,
                    fontSize = 16.sp,
                    fontFamily = fontFamily,
                    color = Color.White
                )
            }
        }
    }
}