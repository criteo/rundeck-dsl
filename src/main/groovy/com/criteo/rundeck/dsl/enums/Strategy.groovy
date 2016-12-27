package com.criteo.rundeck.dsl.enums

enum Strategy {
    NODE_FIRST('node-first'),
    STEP_FIRST('step-first'),
    PARALLEL('parallel')

    final String mnemonic

    private Strategy(mnemonic) {
        this.mnemonic = mnemonic
    }
}