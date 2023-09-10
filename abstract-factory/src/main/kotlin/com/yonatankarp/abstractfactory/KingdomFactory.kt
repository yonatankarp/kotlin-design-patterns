package com.yonatankarp.abstractfactory

/**
 * KingdomFactory factory interface.
 */
internal interface KingdomFactory {
    fun createCastle(): Castle
    fun createKing(): King
    fun createArmy(): Army
}
