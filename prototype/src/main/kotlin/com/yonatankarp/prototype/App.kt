package com.yonatankarp.prototype

import org.slf4j.LoggerFactory

/**
 * The Prototype pattern is a creational design pattern in software development.
 * It is used when the type of objects to create is determined by a prototypical
 * instance, which is cloned to produce new objects. This pattern is used to:
 * - avoid subclasses of an object creator in the client application,
 *   like the abstract factory pattern, does.
 * - avoid the inherent cost of creating a new object in the standard way (e.g.,
 *   using the 'new' keyword)
 *
 * In this example we have a factory class ([HeroFactory]) producing objects
 * by cloning the existing ones. The factory's prototype objects are given as
 * constructor parameters.
 */

internal val logger = LoggerFactory.getLogger("com.yonatankarp.prototype")

/**
 * Program main entry point.
 */
fun main() {
    val elfFactory = HeroFactory(
        ElfMage("cooking"),
        ElfWarlord("cleaning"),
        ElfBeast("protecting")
    )

    val elfMage = elfFactory.createMage()
    val elfWarlord = elfFactory.createWarlord()
    val elfBeast = elfFactory.createBeast()

    logger.info(elfMage.toString())
    logger.info(elfWarlord.toString())
    logger.info(elfBeast.toString())

    val orcFactory = HeroFactory(
        OrcMage("axe"),
        OrcWarlord("sword"),
        OrcBeast("laser")
    )

    val orcMage = orcFactory.createMage()
    val orcWarlord = orcFactory.createWarlord()
    val orcBeast = orcFactory.createBeast()

    logger.info(orcMage.toString())
    logger.info(orcWarlord.toString())
    logger.info(orcBeast.toString())
}
