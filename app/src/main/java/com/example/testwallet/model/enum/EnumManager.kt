package com.morpara.wallet.nl.data.enum

enum class EnumManager(val url: String, val shouldEncrypt: Boolean, val shouldCache: Boolean) {
    SPLASH("init", true, false),
    LOGIN("generic", true, false)
}
