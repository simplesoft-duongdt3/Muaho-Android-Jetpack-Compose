package com.muaho.android_compose.presentation.home.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.muaho.android_compose.ui.theme.MuaHoTheme


data class Category(
    val name: String,
    val thumbUrl: String,
)

@Composable
fun CategoryItemWidget(
    name: String,
    thumbUrl: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.size(
            height = Dp.Infinity,
            width = Dp.Infinity,
        )
    ) {
        Image(
            painter = rememberImagePainter(
                data = thumbUrl,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .aspectRatio(ratio = 1f, matchHeightConstraintsFirst = false)
                .border(0.5.dp, MaterialTheme.colors.secondary, RoundedCornerShape(12.dp))
        )
        Text(
            name,
            style = MaterialTheme.typography.caption,
            maxLines = 1,
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun CategoryList(categories: List<Category>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(count = 5),

        contentPadding = PaddingValues(
            start = 8.dp,
            top = 8.dp,
            end = 8.dp,
            bottom = 8.dp
        ),


        content = {
            items(categories.size) { index ->
                Box(Modifier.padding(8.dp)) {
                    CategoryItemWidget(
                        categories[index].name,
                        categories[index].thumbUrl,
                    )
                }
            }
        },
    )
}

@ExperimentalFoundationApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoryItemWidgetPreview() {
    MuaHoTheme {
        CategoryList(fakeCategories())
    }
}

fun fakeCategories(): List<Category> {
    val items = mutableListOf<Category>()
    for (i in 0..100) {
        items.add(Category(name = "Category ${i+1}", thumbUrl = "https://picsum.photos/48/48?time=${i+1}"))
    }
    return items
}
