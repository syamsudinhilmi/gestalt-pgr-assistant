package com.innocsnt.gestalt.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MemoryPosition(
    val memories: Memories,
    val usage: Int
): Parcelable


@Parcelize
data class Memories(
    val memoryId: Int,
    val memoryName: String,
    val memoryAvatar: String
): Parcelable




