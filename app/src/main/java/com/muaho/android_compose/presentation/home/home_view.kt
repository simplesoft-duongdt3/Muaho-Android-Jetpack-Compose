package com.muaho.android_compose.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.muaho.android_compose.presentation.home.widgets.CategoryList
import com.muaho.android_compose.presentation.home.widgets.TopBarWidget
import kotlin.math.absoluteValue

private fun lerp(start: Float, stop: Float, fraction: Float): Float =
    (1 - fraction) * start + fraction * stop

@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun HomeView(homeViewModel: HomeViewModel) {
    val homeState: HomeState = homeViewModel.homeState


    Scaffold(
        content = {
            if(homeState is HomeState.SuccessState) {
                HomeSuccessBody(homeState)
            } else {
                HomeLoadingBody()
            }

        },
        topBar = {
            if(homeState is HomeState.SuccessState) {
                TopBarWidget(
                    userName = homeState.userName,
                    thumbUrl = homeState.avatarUrl,
                )
            }
        }
    )
}

@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun HomeLoadingBody() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun HomeSuccessBody(homeState: HomeState.SuccessState) {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Hôm nay mua gì?",
                style = MaterialTheme.typography.h6,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalPager(
            count = homeState.banners.size,
            Modifier.height(180.dp),
            contentPadding = PaddingValues(horizontal = 48.dp),
        ) { indexPage ->
            Card(
                modifier = Modifier
                    .graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset =
                            calculateCurrentOffsetForPage(indexPage).absoluteValue

                        // We animate the scaleX + scaleY, between 85% and 100%
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        // We animate the alpha, between 50% and 100%
                        alpha = lerp(
                            start = 0.6f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
                    .fillMaxWidth(),
                shape = RoundedCornerShape(size = 16.dp),
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = homeState.banners[indexPage].thumbUrl,
                    ),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit,
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        CategoryList(homeState.categories)
    }
}
