package com.yonatankarp.adapter

/**
 * The Captain uses [RowingBoat] to sail.
 *
 * This is the client in the pattern.
 */
class Captain(private val rowingBoat: RowingBoat) {
    fun row() = rowingBoat.row()
}
