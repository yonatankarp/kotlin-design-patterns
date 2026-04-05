package com.yonatankarp.chain

import org.slf4j.LoggerFactory

/**
 * The Chain of Responsibility pattern is a behavioral design
 * pattern consisting of command objects and a series of
 * processing objects. Each processing object contains logic
 * that defines the types of command objects it can handle;
 * the rest are passed to the next processing object in the
 * chain.
 *
 * In this example we organize the request handlers
 * ([RequestHandler]) into a chain where each handler has a
 * chance to act on the request on its turn. Here the king
 * ([OrcKing]) makes requests and the military orcs
 * ([OrcCommander], [OrcOfficer], [OrcSoldier]) form the
 * handler chain.
 */

internal val logger = LoggerFactory.getLogger("com.yonatankarp.chain")

/**
 * Program entry point.
 */
fun main() {
    val king = OrcKing()
    king.makeRequest(Request(RequestType.DEFEND_CASTLE, "defend castle"))
    king.makeRequest(Request(RequestType.TORTURE_PRISONER, "torture prisoner"))
    king.makeRequest(Request(RequestType.COLLECT_TAX, "collect tax"))
}
