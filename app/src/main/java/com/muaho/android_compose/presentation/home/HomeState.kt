package com.muaho.android_compose.presentation.home


sealed interface HomeState {
    data class SuccessState(
        val userName: String,
        val avatarUrl: String,
        val banners: List<Banner>,
        val categories: List<Category>,
    ): HomeState {
        data class Banner(
            val thumbUrl: String,
            val name: String,
        )

        data class Category(
            val thumbUrl: String,
            val name: String,
        )
    }

    object Loading: HomeState
}
