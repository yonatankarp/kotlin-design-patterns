package com.yonatankarp.builder

/**
 * Represents the hairstyle of a [Hero].
 */
internal enum class HairType(private val title: String) {
    BALD("bald"),
    CURLY("curly"),
    LONG_CURLY("long curly"),
    LONG_STRAIGHT("long straight"),
    SHORT("short"),
    ;

    override fun toString() = title
}
