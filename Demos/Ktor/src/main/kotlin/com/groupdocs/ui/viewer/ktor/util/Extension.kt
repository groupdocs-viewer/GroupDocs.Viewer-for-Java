package com.groupdocs.ui.viewer.ktor.util

import com.groupdocs.viewer.options.Rotation

fun Int.angleToRotation() =
    when (if (this > 270 || this < -270) this / 360 else this) {
        -270 -> Rotation.ON_90_DEGREE
        -180 -> Rotation.ON_180_DEGREE
        -90 -> Rotation.ON_270_DEGREE
        90 -> Rotation.ON_90_DEGREE
        180 -> Rotation.ON_180_DEGREE
        270 -> Rotation.ON_270_DEGREE
        else -> null // 360, 0, -360
    }

fun Rotation.rotationToAngle() = when (this) {
    Rotation.ON_90_DEGREE -> 90
    Rotation.ON_180_DEGREE -> 180
    Rotation.ON_270_DEGREE -> 270
    else -> 0
}