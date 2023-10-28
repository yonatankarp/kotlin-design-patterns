package com.yonatankarp.adapter

internal fun FishingBoat.toRowingBoat(): RowingBoat = object : RowingBoat {
    override fun row() {
        logger.info("Using extension function adapter")
        sail()
    }
}
