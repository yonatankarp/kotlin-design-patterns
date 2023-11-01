package com.yonatankarp.strategy.utils

import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.AppenderBase
import org.slf4j.LoggerFactory

internal class InMemoryAppender : AppenderBase<ILoggingEvent>() {
    private val log = mutableListOf<ILoggingEvent>()

    val size: Int
        get() = log.size
    val lastMessage: String
        get() = log[log.size - 1].formattedMessage

    init {
        (LoggerFactory.getLogger("root") as Logger).addAppender(this)
        start()
    }

    override fun append(eventObject: ILoggingEvent) {
        log.add(eventObject)
    }

    fun clearAll() = log.clear()
}
