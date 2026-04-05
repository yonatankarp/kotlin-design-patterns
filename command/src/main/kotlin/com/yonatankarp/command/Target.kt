package com.yonatankarp.command

import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal val logger: Logger =
    LoggerFactory.getLogger("com.yonatankarp.command")

/**
 * Base class for spell targets.
 *
 * A target has a [Size] and a [Visibility] that can be toggled
 * by invoking [changeSize] or [changeVisibility].
 */
internal open class Target(
    var size: Size,
    var visibility: Visibility,
) {
    /**
     * Logs the current status of this target.
     */
    fun printStatus() {
        logger.info("$this, [size=$size] [visibility=$visibility]")
    }

    /**
     * Toggles the size of this target between [Size.NORMAL]
     * and [Size.SMALL].
     */
    fun changeSize() {
        size =
            if (size == Size.NORMAL) Size.SMALL else Size.NORMAL
    }

    /**
     * Toggles the visibility of this target between
     * [Visibility.VISIBLE] and [Visibility.INVISIBLE].
     */
    fun changeVisibility() {
        visibility =
            if (visibility == Visibility.INVISIBLE) {
                Visibility.VISIBLE
            } else {
                Visibility.INVISIBLE
            }
    }
}
