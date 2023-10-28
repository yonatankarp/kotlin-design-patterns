package com.yonatankarp.composite

import org.slf4j.LoggerFactory

/**
 * The Composite pattern is a partitioning design pattern. The Composite pattern
 * describes that a group of objects is to be treated in the same way as a
 * single instance of an object. The intent of a composite is to "compose"
 * objects into tree structures to represent part-whole hierarchies.
 * Implementing the Composite pattern lets clients treat individual objects and
 * compositions uniformly.
 *
 * In this example we have sentences composed of words composed of letters. All
 * the objects can be treated through the same interface
 * ({@link LetterComposite}).
 */

internal val logger = LoggerFactory.getLogger("com.yonatankarp.composite")

/**
 * Program entry point.
 */
fun main() {
    val messenger = Messenger()

    logger.info("Message from the orcs: ")
    messenger.messageFromOrcs().print()

    logger.info("Message from the elves: ")
    messenger.messageFromElves().print()
}
