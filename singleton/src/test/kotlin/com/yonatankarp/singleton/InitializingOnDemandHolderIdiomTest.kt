package com.yonatankarp.singleton

/**
 * Create a new singleton test instance using the given 'getInstance' method.
 */
internal class InitializingOnDemandHolderIdiomTest :
    SingletonTest<InitializingOnDemandHolderIdiom> {
    override val singletonInstanceMethod: () -> InitializingOnDemandHolderIdiom =
        { InitializingOnDemandHolderIdiom.instance }
}
