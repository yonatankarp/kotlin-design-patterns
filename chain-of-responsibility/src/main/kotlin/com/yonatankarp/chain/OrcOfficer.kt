package com.yonatankarp.chain

/**
 * An [RequestHandler] that tortures prisoners.
 *
 * The orc officer handles [RequestType.TORTURE_PRISONER]
 * requests.
 */
internal class OrcOfficer : RequestHandler {
    override val name = "Orc officer"
    override val priority = 3

    override fun canHandle(request: Request) =
        request.type == RequestType.TORTURE_PRISONER

    override fun handle(request: Request) {
        request.markHandled()
        logger.info("{} handling request \"{}\"", name, request)
    }
}
