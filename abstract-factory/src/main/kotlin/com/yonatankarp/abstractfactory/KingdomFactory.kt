package com.yonatankarp.abstractfactory

/**
 * Abstract factory for creating [King], [Castle], and [Army] families.
 */
internal interface KingdomFactory {
    fun createCastle(): Castle
    fun createKing(): King
    fun createArmy(): Army
}
