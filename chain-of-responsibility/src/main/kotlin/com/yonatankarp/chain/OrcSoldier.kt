package com.yonatankarp.chain

/**
 * An [RequestHandler] that collects taxes.
 *
 * The orc soldier handles [RequestType.COLLECT_TAX]
 * requests.
 */
internal class OrcSoldier : RequestHandler {
    override val name = "Orc soldier"
    override val priority = 1

    override fun canHandle(request: Request) =
        request.type == RequestType.COLLECT_TAX

    override fun handle(request: Request) {
        request.markHandled()
        logger.info("{} handling request \"{}\"", name, request)
    }
}
