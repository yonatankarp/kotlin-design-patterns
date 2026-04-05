package com.yonatankarp.chain

/**
 * Enumerates the types of requests that can be made in the
 * chain of responsibility.
 */
enum class RequestType {
    COLLECT_TAX,
    DEFEND_CASTLE,
    TORTURE_PRISONER,
    ;

    override fun toString() = name.lowercase()
}
