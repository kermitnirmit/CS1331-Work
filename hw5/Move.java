public class Move {
    private Ply whitePly;
    private Ply blackPly;
    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }


    /**
    * Returns value of whitePly
    * @return
    */
    public Ply getWhitePly() {
        return whitePly;
    }

    /**
    * Sets new value of whitePly
    * @param
    */
    public void setWhitePly(Ply whitePly) {
        this.whitePly = whitePly;
    }

    /**
    * Returns value of blackPly
    * @return
    */
    public Ply getBlackPly() {
        return blackPly;
    }

    /**
    * Sets new value of blackPly
    * @param
    */
    public void setBlackPly(Ply blackPly) {
        this.blackPly = blackPly;
	}
}
