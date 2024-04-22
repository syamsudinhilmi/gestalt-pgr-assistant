package com.innocsnt.gestalt.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Construct(
    val consName: String,
    val consFrame: String,
    val consAvatar: String,
    val consAvatar3d: String,
    val consAvatarAwaken: String,
    val consAvatarDorm: String,
    val consAvatarModel: String,
    val consRank: String,
    val consInfo: String,
    val consSpecialty: String,
//    Stats
    val consHp: String,
    val consAtk: String,
    val consDef: String,
    val consCrit: String,
//    Basic Info
    val consMentalAge: String,
    val consActiveDate: String,
    val consHeight: String,
    val consWeight: String,
    val consFluidType: String,
//    Attributes
    val consClass: Class,
    val consElementDistribution: List<ElementDistribution>,
    val consMemoryPosition: List<MemoryPosition>
): Parcelable

@Parcelize
data class Class(
    val classId: Int,
    val className: String,
    val classAvatar: String
): Parcelable
