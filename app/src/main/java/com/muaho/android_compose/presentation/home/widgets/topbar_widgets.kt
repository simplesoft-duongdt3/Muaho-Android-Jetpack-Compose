package com.muaho.android_compose.presentation.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.muaho.android_compose.ui.theme.MuaHoTheme

@Composable
fun TopBarWidget(
    userName: String,
    thumbUrl: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .size(width = Dp.Infinity, height = 48.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        Image(
            painter = rememberImagePainter(
                data = thumbUrl,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .border(0.5.dp, MaterialTheme.colors.secondary, RoundedCornerShape(4.dp))
                .size(width = 40.dp, height = 40.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Column(modifier = Modifier.weight(weight = 1f)) {
            Text(
                "Xin chào",
                style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
                maxLines = 1,
            )
            Text(
                userName,
                style = MaterialTheme.typography.body2,
                maxLines = 1,
            )
        }

        IconButton(onClick = { }, modifier = Modifier.padding(0.dp)) {
            Icon(
                Icons.Outlined.ShoppingCart,
                contentDescription = "Cart",
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .size(26.dp)
                    .border(0.5.dp, MaterialTheme.colors.secondary, RoundedCornerShape(4.dp))
                    .padding(2.dp),
            )
        }

        IconButton(onClick = { }) {
            Icon(
                Icons.Outlined.Search,
                contentDescription = "Search",
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .size(26.dp)
                    .border(0.5.dp, MaterialTheme.colors.secondary, RoundedCornerShape(4.dp))
                    .padding(2.dp),
            )
        }

        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TopBarWidgetPreview() {
    MuaHoTheme {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            TopBarWidget(
                userName = "doanthanhduong",
                thumbUrl = "https://picsum.photos/128/128?time=1",
            )
            Column(Modifier.fillMaxHeight()) {

            }
        }

    }
}