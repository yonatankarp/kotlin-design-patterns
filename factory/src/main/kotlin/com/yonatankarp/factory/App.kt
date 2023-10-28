package com.yonatankarp.factory

import org.slf4j.LoggerFactory

internal val logger = LoggerFactory.getLogger("com.yonatankarp.factory")

/**
 * Program main entry point.
 */
fun main() {
    logger.info("The alchemist begins his work.")
    val copper = CoinFactory.getCoin(CoinType.COPPER)
    val gold = CoinFactory.getCoin(CoinType.GOLD)
    logger.info(copper.description)
    logger.info(gold.description)
}
