job('Description containing XML reserved characters (should go into CDATA)') {
    description('<hello>"&\'<world>')
}
