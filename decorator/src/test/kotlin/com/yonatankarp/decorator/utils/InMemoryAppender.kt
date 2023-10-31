package com.yonatankarp.decorator.utils

import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.AppenderBase
import org.slf4j.LoggerFactory

/**
 * This class, [InMemoryAppender], is a custom Logback Appender
 * designed to capture and store log events for a specific class represented
 * by 'clazz'. It extends the AppenderBase<ILoggingEvent> class and maintains
 * an in-memory log of log events for the specified class.
 * This is particularly useful for testing and debugging purposes when you
 * want to capture and analyze log messages generated during the execution of
 * a specific class or component.
 */
internal class InMemoryAppender(clazz: Class<*>) :
    AppenderBase<ILoggingEvent>() {
    private val log = mutableListOf<ILoggingEvent>()

    val lastMessage: String
        get() = log[log.size - 1].message

    val logSize: Int
        get() = log.size

    init {
        (LoggerFactory.getLogger(clazz) as Logger).addAppender(this)
        start()
    }

    override fun append(eventObject: ILoggingEvent) {
        log.add(eventObject)
    }

    fun clearAll() = log.clear()
}
