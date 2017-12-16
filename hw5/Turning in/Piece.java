/**
 * Represents a Piece
 * @author nshah372
 * @version 2.0
 */
public abstract class Piece {
    private Color color;
    /**
     * Constructor for a Piece
     * @param   color     [WHITE or BLACK]
     */
    public Piece(Color color) {
        this.color = color;
    }
    /**
     * The color of the piece
     * @return [the color]
     */
    public Color getColor() {
        return color;
    }
    /**
     * checks if two squares are equal
     * @param   other         [the other piece to check]
     * @return        [true if they have the same algebraic name, false
     *                  otherwise]
     */
    public boolean equals(Object other) {
        String algName;
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Piece)) {
            return false;
        }
        Piece that = (Piece) other;
        algName = that.algebraicName();
        return this.algebraicName().equals(algName);
    }
    /**
     * hashCode of a piece
     * @return [uses the ASCII value of the algebraic name]
     */
    public int hashCode() {
        int result = 17;
        result += 31 * (this.algebraicName().charAt(0));
        return result;
    }
    /**
     * returns of algebraic name of that piece
     * @return [returns a string with the algebraic name of the piece]
     */
    public abstract String algebraicName();
    /**
    * returns of FEN name of that piece
    * @return [returns a string with the FEN name of the piece]
     */
    public abstract String fenName();
    /**
     * returns a square array of possible squares the piece could move to
     *              from the square
     * @param  square        [square where the piece currently is]
     * @return        [a square array of possible squares the piece could move
     *                  to ]
     */
    public abstract Square[] movesFrom(Square square);
}
