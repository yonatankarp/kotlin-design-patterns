package com.yonatankarp.abstractfactory

/**
 * [KingdomFactory] that creates orcish [King], [Castle], and [Army].
 */
internal class OrcKingdomFactory : KingdomFactory {
    override fun createCastle() = OrcCastle()
    override fun createKing() = OrcKing()
    override fun createArmy() = OrcArmy()
}
