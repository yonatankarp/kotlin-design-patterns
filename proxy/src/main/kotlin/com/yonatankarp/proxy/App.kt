package com.yonatankarp.proxy

import org.slf4j.LoggerFactory

/**
 * A proxy, in its most general form, is a class functioning as an interface to
 * something else. The proxy could interface to anything: a network connection,
 * a large object in memory, a file, or some other resource that is expensive or
 * impossible to duplicate. In short, a proxy is a wrapper or agent object that
 * is being called by the client to access the real serving object behind the
 * scenes.
 *
 * The Proxy design pattern allows you to provide an interface to other objects
 * by creating a wrapper class as the proxy. The wrapper class, which is the
 * proxy, can add additional functionality to the object of interest without
 * changing the object's code.
 *
 * In this example the proxy ({@link WizardTowerProxy}) controls access to the
 * actual object ({@link IvoryTower}).
 */

internal val logger = LoggerFactory.getLogger("com.yonatankarp.proxy")

/**
 * Program entry point.
 */
fun main() {
    val proxy = WizardTowerProxy(IvoryTower())

    proxy.enter(Wizard("Red wizard"))
    proxy.enter(Wizard("White wizard"))
    proxy.enter(Wizard("Black wizard"))
    proxy.enter(Wizard("Green wizard"))
    proxy.enter(Wizard("Brown wizard"))
}
