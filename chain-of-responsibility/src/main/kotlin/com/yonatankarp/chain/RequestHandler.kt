package com.yonatankarp.chain

/**
 * Defines the contract for a handler in the chain of
 * responsibility. Each handler declares the [RequestType] it
 * can handle, its [priority] within the chain, and the
 * [handle] action to perform when a matching [Request] arrives.
 */
interface RequestHandler {
    /**
     * The display name of this handler.
     */
    val name: String

    /**
     * The priority of this handler within the chain.
     * Lower values are evaluated first.
     */
    val priority: Int

    /**
     * Returns `true` if this handler can process [request].
     */
    fun canHandle(request: Request): Boolean

    /**
     * Processes the given [request] and marks it as handled.
     */
    fun handle(request: Request)
}
