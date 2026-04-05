package com.yonatankarp.chain

/**
 * The [OrcKing] issues requests that are dispatched through
 * the chain of [RequestHandler]s. Each handler is evaluated
 * in order of [RequestHandler.priority]; the first handler
 * that can process the request does so.
 */
class OrcKing {
    private val handlers: List<RequestHandler> = listOf(
        OrcCommander(),
        OrcOfficer(),
        OrcSoldier(),
    )

    /**
     * Issues the given [request] to the chain. The handler
     * with the lowest priority that can handle it processes
     * the request.
     */
    fun makeRequest(request: Request) {
        handlers
            .sortedBy { it.priority }
            .firstOrNull { it.canHandle(request) }
            ?.handle(request)
    }
}
