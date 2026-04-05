package com.yonatankarp.chain

/**
 * Represents a request to be processed by the chain.
 *
 * Each [Request] carries a [RequestType] and a human-readable
 * description. Once handled by a [RequestHandler], it is marked
 * as handled via [markHandled].
 *
 * @property type the type of this request, used by handlers to
 *   determine whether they can process it
 * @property description a human-readable description of the
 *   request
 */
class Request(
    val type: RequestType,
    val description: String,
) {
    /**
     * Whether this request has been handled by a handler in
     * the chain.
     */
    var isHandled: Boolean = false
        private set

    /**
     * Marks this request as handled.
     */
    fun markHandled() {
        isHandled = true
    }

    override fun toString() = description
}
