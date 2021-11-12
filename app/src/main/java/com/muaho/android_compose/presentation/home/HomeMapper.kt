package com.muaho.android_compose.presentation.home

import com.muaho.android_compose.domain.HomeEntity

class HomeMapper {
    fun mapHome(homeEntity: HomeEntity): HomeState {
        return HomeState.SuccessState(
            userName = homeEntity.userName,
            avatarUrl = homeEntity.avatarUrl,
            categories = homeEntity.categories.map {
                HomeState.SuccessState.Category(
                    thumbUrl = it.thumbUrl,
                    name = it.name,
                )
            },
            banners = homeEntity.banners.map {
                HomeState.SuccessState.Banner(
                    name = it.name,
                    thumbUrl = it.thumbUrl,
                )
            }
        )
    }
}