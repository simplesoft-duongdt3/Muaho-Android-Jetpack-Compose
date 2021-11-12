package com.muaho.android_compose.data

import com.muaho.android_compose.domain.HomeEntity
import com.muaho.android_compose.domain.HomeRepository

class HomeRepositoryImpl: HomeRepository {
    override suspend fun getHome(): HomeEntity {
        return HomeEntity(
            userName = "Duong",
            avatarUrl = "https://picsum.photos/48/48",
            banners = (1..10).map {
                HomeEntity.Banner(
                    name = "Banner $it",
                    thumbUrl = "https://picsum.photos/600/360?time=$it",
                )
            },
            categories = (1..20).map {
                HomeEntity.Category(
                    name = "Cate $it",
                    thumbUrl = "https://picsum.photos/48/48?time=$it",
                )
            }
        )
    }
}