package com.yonatankarp.abstractfactory

/**
 * [KingdomFactory] that creates elven [King], [Castle], and [Army].
 */
internal class ElfKingdomFactory : KingdomFactory {
    override fun createCastle() = ElfCastle()
    override fun createKing() = ElfKing()
    override fun createArmy() = ElfArmy()
}
