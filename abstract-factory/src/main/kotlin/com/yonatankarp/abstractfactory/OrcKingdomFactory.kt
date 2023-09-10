package com.yonatankarp.abstractfactory

/**
 * OrcKingdomFactory concrete factory.
 */
internal class OrcKingdomFactory : KingdomFactory {
    override fun createCastle() = OrcCastle()
    override fun createKing() = OrcKing()
    override fun createArmy() = OrcArmy()
}
