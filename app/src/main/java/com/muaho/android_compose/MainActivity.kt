package com.muaho.android_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muaho.android_compose.ui.theme.MuaHoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.google.accompanist.pager.ExperimentalPagerApi
import com.muaho.android_compose.data.HomeRepositoryImpl
import com.muaho.android_compose.presentation.home.HomeMapper
import com.muaho.android_compose.presentation.home.HomeView
import com.muaho.android_compose.presentation.home.HomeViewModel

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<HomeViewModel> {
            HomeViewModel.Factory(
                repository = HomeRepositoryImpl(),
                homeMapper = HomeMapper(),
            )
        }

        setContent {
            MuaHoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MuaHoTheme {
                        HomeView(viewModel)
                    }
                }
            }
        }
    }


}