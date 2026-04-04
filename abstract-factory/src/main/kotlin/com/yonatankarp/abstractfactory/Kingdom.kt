package com.yonatankarp.abstractfactory

internal data class Kingdom(
    val king: King,
    val castle: Castle,
    val army: Army,
) {
    /**
     * Creates [KingdomFactory] instances based on [KingdomType].
     */
    object FactoryMaker {
        /**
         * Returns the appropriate [KingdomFactory] for [type].
         */
        fun makeFactory(type: KingdomType): KingdomFactory = when (type) {
            KingdomType.ELF -> ElfKingdomFactory()
            KingdomType.ORC -> OrcKingdomFactory()
        }

        /**
         * Enumerates the available kingdom types.
         */
        enum class KingdomType {
            ELF,
            ORC,
;
        }
    }
}
