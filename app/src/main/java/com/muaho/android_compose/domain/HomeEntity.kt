package com.muaho.android_compose.domain

data class HomeEntity(
    val userName: String,
    val avatarUrl: String,
    val banners: List<Banner>,
    val categories: List<Category>,
) {
    data class Banner(
        val thumbUrl: String,
        val name: String,
    )

    data class Category(
        val thumbUrl: String,
        val name: String,
    )
}