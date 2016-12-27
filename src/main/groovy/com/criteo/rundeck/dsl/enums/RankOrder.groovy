package com.criteo.rundeck.dsl.enums

enum RankOrder {
    ASCENDING('ascending'),
    DESCENDING('descending')

    public final String mnemonic

    private RankOrder(mnemonic) {
        this.mnemonic = mnemonic
    }
}