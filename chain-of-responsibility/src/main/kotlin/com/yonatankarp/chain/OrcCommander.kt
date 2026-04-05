package com.yonatankarp.chain

/**
 * An [RequestHandler] that defends the castle.
 *
 * The orc commander handles [RequestType.DEFEND_CASTLE]
 * requests.
 */
internal class OrcCommander : RequestHandler {
    override val name = "Orc commander"
    override val priority = 2

    override fun canHandle(request: Request) =
        request.type == RequestType.DEFEND_CASTLE

    override fun handle(request: Request) {
        request.markHandled()
        logger.info("$name handling request \"$request\"")
    }
}
