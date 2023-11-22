package com.home.moviesappjc.ui.navigation

import android.text.Layout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material.TabRow
import androidx.compose.material3.DividerDefaults
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
import kotlinx.coroutines.launch

@Composable
fun Play() {
    val lattoFamily =  FontFamily(
        Font(R.font.lato, FontWeight.Normal)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorBackground)
    ) {
        TitleSection1(fontFamily = lattoFamily)
        SearchBar()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(device = "spec:width=1080px,height=1920px,dpi=480")
@Composable()
fun PreviewPlay() {
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
//        TabContent(pagerState = pagerState)
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
            .padding(top = 36.dp, start = 24.dp, end = 68.dp, bottom = 20.dp)
            .fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("Sherlock Holmes") }

    TextField(
        value = text,
        onValueChange = { text = it },
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
                modifier = Modifier
                    .wrapContentSize()
                    .padding(0.dp),
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
fun TabContent(pagerState: PagerState, items: Movie) {
    HorizontalPager(state = pagerState) { index ->
        when (index) {
            0 -> {}
            1 -> {}
            2 -> {}
            3 -> {}
        }
        
    }
}



