package com.muaho.android_compose.presentation.home.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muaho.android_compose.ui.theme.MuaHoTheme
import com.muaho.android_compose.ui.theme.borderColor

@Composable
fun CustomFillButtonWidget(text: String) {
    Button(
        onClick = { /* ... */ },
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
fun CustomOutlinedButtonWidget(text: String, active: Boolean) {
    OutlinedButton(
        onClick = { /* ... */ },
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
fun CustomTextButtonWidget(text: String) {
    TextButton(
        onClick = { /* ... */ },
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
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            CustomFillButtonWidget("Normal button")
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            CustomOutlinedButtonWidget("Outline active button", active = true)
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            CustomOutlinedButtonWidget("Outline inactive button", active = false)
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            CustomTextButtonWidget("Text button")

        }

    }
}
