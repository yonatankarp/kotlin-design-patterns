package com.yonatankarp.abstractfactory

/**
 * ElfKingdomFactory concrete factory.
 */
internal class ElfKingdomFactory : KingdomFactory {
    override fun createCastle() = ElfCastle()
    override fun createKing() = ElfKing()
    override fun createArmy() = ElfArmy()
}
