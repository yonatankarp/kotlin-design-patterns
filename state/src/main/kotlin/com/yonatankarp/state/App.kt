package com.yonatankarp.state

import org.slf4j.LoggerFactory

internal val logger = LoggerFactory.getLogger("com.yonatankarp.state")

/**
 * Program entry point.
 */
fun main() {
    val mammoth = Mammoth()
    mammoth.observe()
    mammoth.timePasses()
    mammoth.observe()
    mammoth.timePasses()
    mammoth.observe()
}
