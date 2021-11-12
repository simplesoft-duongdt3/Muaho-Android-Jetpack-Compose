package com.muaho.android_compose.domain

interface HomeRepository {
    suspend fun getHome(): HomeEntity
}