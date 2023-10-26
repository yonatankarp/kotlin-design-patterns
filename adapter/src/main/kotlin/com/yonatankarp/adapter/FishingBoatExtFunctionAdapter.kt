package com.yonatankarp.adapter

import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("com.yonatankarp.adapter.FishingBoat.toRowingBoat")

internal fun FishingBoat.toRowingBoat(): RowingBoat = object : RowingBoat {
    override fun row() {
        logger.info("Using extension function adapter")
        sail()
    }
}
