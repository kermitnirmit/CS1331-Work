/**
 * Represents a Move
 * @author nshah372
 * @version 1.0
 */
public class Move {
    private Ply whitePly;
    private Ply blackPly;
    /**
     * Constructor for a move
     * @param  whitePly      [the white move]
     * @param  blackPly      [the black move]
     */
    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }


    /**
    * Returns value of whitePly
    * @return returns whiteply
    */
    public Ply getWhitePly() {
        return whitePly;
    }

    /**
    * Sets new value of whitePly
    * @param whitePly  new value of whitePly
    */
    public void setWhitePly(Ply whitePly) {
        this.whitePly = whitePly;
    }

    /**
    * Returns value of blackPly
    * @return   returns blackPly
    */
    public Ply getBlackPly() {
        return blackPly;
    }

    /**
    * Sets new value of blackPly
    * @param blackPly   new value of blackPly
    */
    public void setBlackPly(Ply blackPly) {
        this.blackPly = blackPly;
    }
}
