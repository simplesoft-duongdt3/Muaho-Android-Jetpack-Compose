package com.muaho.android_compose.presentation.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.muaho.android_compose.ui.theme.MuaHoTheme

@Composable
fun ShopItemWidget(
        name: String,
        description: String,
        thumbUrl: String,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberImagePainter(
                data = thumbUrl,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
                .clip(RoundedCornerShape(12.dp))                       // clip to the circle shape
                .border(0.5.dp, MaterialTheme.colors.secondary, RoundedCornerShape(12.dp))
        )
        Text(
            name,
            style = MaterialTheme.typography.body1,
            maxLines = 1,
        )
        Text(
            description,
            style = MaterialTheme.typography.caption,
            maxLines = 1,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShopItemWidgetPreview() {
    MuaHoTheme {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ) {
            ShopItemWidget(
                name = "Vinmart Q1",
                description = "Q1, TP HCM",
                thumbUrl = "https://picsum.photos/128/128?time=1",
            )
            ShopItemWidget(
                name = "Vinmart Tân Phú",
                description = "Tân Phú, TP HCM",
                thumbUrl = "https://picsum.photos/128/128?time=2",
            )
        }
    }
}
