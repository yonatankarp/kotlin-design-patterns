package com.yonatankarp.abstractfactory

import com.yonatankarp.abstractfactory.Kingdom.FactoryMaker.KingdomType
import com.yonatankarp.abstractfactory.Kingdom.FactoryMaker.makeFactory
import org.slf4j.LoggerFactory

internal val logger = LoggerFactory.getLogger("com.yonatankarp.abstractfactory")

/**
 * Program main entry point.
 */
fun main() {
    logger.info("elf kingdom")
    val elfKingdom = createKingdom(KingdomType.ELF)
    logger.info(elfKingdom.army.description)
    logger.info(elfKingdom.castle.description)
    logger.info(elfKingdom.king.description)

    logger.info("orc kingdom")
    val orcKingdom = createKingdom(KingdomType.ORC)
    logger.info(orcKingdom.army.description)
    logger.info(orcKingdom.castle.description)
    logger.info(orcKingdom.king.description)
}

/**
 * Creates kingdom.
 * @param kingdomType type of Kingdom
 */
private fun createKingdom(kingdomType: KingdomType): Kingdom {
    val kingdomFactory = makeFactory(kingdomType)
    return Kingdom(
        king = kingdomFactory.createKing(),
        castle = kingdomFactory.createCastle(),
        army = kingdomFactory.createArmy(),
    )
}
