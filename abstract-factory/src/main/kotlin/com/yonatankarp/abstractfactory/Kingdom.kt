package com.yonatankarp.abstractfactory

internal data class Kingdom(
    val king: King,
    val castle: Castle,
    val army: Army,
) {
    /**
     * The factory of kingdom factories.
     */
    object FactoryMaker {
        /**
         * The factory method to create KingdomFactory concrete objects.
         */
        fun makeFactory(type: KingdomType): KingdomFactory = when (type) {
            KingdomType.ELF -> ElfKingdomFactory()
            KingdomType.ORC -> OrcKingdomFactory()
        }

        /**
         * Enumeration for the different types of Kingdoms.
         */
        enum class KingdomType {
            ELF,
            ORC,
;
        }
    }
}
