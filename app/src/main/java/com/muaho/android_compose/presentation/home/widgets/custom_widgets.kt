package com.muaho.android_compose.presentation.home.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muaho.android_compose.ui.theme.MuaHoTheme
import com.muaho.android_compose.ui.theme.borderColor

@Composable
fun CustomFillButtonWidget(text: String, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .heightIn(min = 48.dp)
            .clickable(enabled = false, onClick = {})
            .fillMaxWidth(),

        ) {
        Text(text)
    }
}

@Composable
fun CustomOutlinedButtonWidget(
    text: String,
    active: Boolean = true,
    onClick: () -> Unit = {},

    ) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .heightIn(min = 48.dp)
            .clickable(enabled = false, onClick = {})
            .fillMaxWidth()
            .border(
                if (active) {
                    BorderStroke(
                        width = 0.5.dp,
                        color = MaterialTheme.colors.primary,
                    )
                } else {
                    BorderStroke(
                        width = 0.5.dp,
                        color = borderColor,
                    )
                },
                shape = RoundedCornerShape(12.dp),
            ),

        ) {
        Text(
            text = text,
            color = if (active) {
                MaterialTheme.colors.primary
            } else {
                borderColor
            },
        )
    }
}

@Composable
fun CustomOutlineButtonIconWidget(
    text: String,
    active: Boolean = true,
    iconVector: ImageVector,
    onClick: () -> Unit = {},
    ) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .heightIn(min = 48.dp)
            .clickable(enabled = false, onClick = {})
            .fillMaxWidth()
            .border(
                if (active) {
                    BorderStroke(
                        width = 0.5.dp,
                        color = MaterialTheme.colors.primary,
                    )
                } else {
                    BorderStroke(
                        width = 0.5.dp,
                        color = borderColor,
                    )
                },
                shape = RoundedCornerShape(12.dp),
            ),

        ) {
        Icon(
            iconVector,
            contentDescription = null,
            modifier = Modifier.size(36.dp, 36.dp),
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text = text,
            color = if (active) {
                MaterialTheme.colors.primary
            } else {
                borderColor
            },
        )
    }
}

@Composable
fun CustomTextButtonWidget(
    text: String,
    onClick: () -> Unit = {},
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .heightIn(min = 48.dp)
            .clickable(enabled = false, onClick = {})
            .fillMaxWidth()

    ) {
        Text(text)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonPreview() {
    MuaHoTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            CustomFillButtonWidget("Normal button")
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            CustomOutlinedButtonWidget("Outline active button")
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            CustomOutlinedButtonWidget("Outline inactive button", active = false)
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            CustomTextButtonWidget("Text button")
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            CustomOutlineButtonIconWidget(
                text = "Login with Google",
                iconVector = Icons.Rounded.Home,
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            CustomOutlineButtonIconWidget(
                text = "Login with Facebook",
                iconVector = Icons.Rounded.Search,
            )
        }

    }
}
