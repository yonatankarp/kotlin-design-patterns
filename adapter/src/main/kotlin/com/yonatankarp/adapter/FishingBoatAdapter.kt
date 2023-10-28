package com.yonatankarp.adapter

/**
 * Adapter class. Adapts the interface of the device ([FishingBoat]) into
 * [RowingBoat] interface expected by the client ([Captain]).
 */
internal class FishingBoatAdapter(private val boat: FishingBoat) : RowingBoat {
    override fun row() {
        logger.info("Using class adapter")
        boat.sail()
    }
}
