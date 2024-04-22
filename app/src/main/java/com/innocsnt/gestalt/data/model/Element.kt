package com.innocsnt.gestalt.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ElementDistribution(
    val element: Element,
    val percentage: Double
): Parcelable

@Parcelize
data class Element(
    val elementId: Int,
    val elementName: String,
    val elementAvatar: String
): Parcelable
