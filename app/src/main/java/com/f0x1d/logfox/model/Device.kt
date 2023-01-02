package com.f0x1d.logfox.model

import android.os.Build
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Device @Inject constructor() {

    private val data = mapOf<String, String>(
        "SDK" to Build.VERSION.SDK_INT.toString(),
        "PRODUCT_NAME" to Build.PRODUCT,
        "DEVICE_NAME" to Build.DEVICE,
        "BOARD_NAME" to Build.BOARD,
        "SUPPORTED_ABIS" to Build.SUPPORTED_ABIS.joinToString(),
        "MANUFACTURER" to Build.MANUFACTURER,
        "BRAND" to Build.BRAND,
        "MODEL" to Build.MODEL
    )
        .map { "${it.key}: ${it.value}" }
        .joinToString("\n")

    override fun toString() = data
}