package com.yonatankarp.staticfactory.method

import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("Static Factory Method")

fun main() {
    val dollars = Money.dollars(5)
    logger.info(dollars.toString())

    val euros = Money.euros(5)
    logger.info(euros.toString())
}
