/**
 * Represents a square on the board
 *
 * @author nshah372
 * @version 2.0
 */

public class Square {
    private char file;
    private char rank;
    /**
     * Creates a Square with all required parameters.
     *
     * @param file the Square's horizontal position
     * @param rank the Square's vertical position
     */
    public Square(char file, char rank) throws InvalidSquareException {
        this.file = file;
        this.rank = rank;

        if (this.file < 'a' || this.file > 'h') {
            throw new InvalidSquareException((char) this.file
                                            + ""
                                            + (char) this.rank
                                            + " isn't on the board");
        }
        if (this.rank < '1' || this.rank > '8') {
            throw new InvalidSquareException((char) this.file
                                            + ""
                                            + (char) this.rank
                                            + " isn't on the board");
        }
    }
    /**
     * Creates a square with the requiored parameters
     * @param  name                    the file and rank of the
     *                                 Square]
     * @throws InvalidSquareException  a square that doesnt exist on the board
     */
    public Square(String name) throws InvalidSquareException {
        if (name.length() != 2) {
            throw new InvalidSquareException("Must have a file and rank");
        }
        this.file = name.charAt(0);
        this.rank = name.charAt(1);
        if (this.file < 'a' || this.file > 'h') {
            throw new InvalidSquareException((char) this.file
                                            + ""
                                            + (char) this.rank
                                            + " isn't on the board");
        }
        if (this.rank < '1' || this.rank > '8') {
            throw new InvalidSquareException((char) this.file
                                            + ""
                                            + (char) this.rank
                                            + " isn't on the board");
        }
    }

    /**
     * Prints out a square
     * @return the square's file and rank
     */
    public String toString() {
        return file + "" + rank;
    }
    /**
     * Checks if a square is equal to another square
     * @param  other         the second square
     * @return               true if they're the same square, false otherwise
     */
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Square)) {
            return false;
        }
        Square that = (Square) other;
        return this.file == that.file && this.rank == that.rank;
    }
    /**
     * @return this Square's file
     */
    public char getFile() {
        return file;
    }
    /**
     * @return this Square's rank
     */
    public char getRank() {
        return rank;
    }
    /**
     * THE hashCode of a square
     * @return the hashCode
     */
    public int hashCode() {
        int result = 17;
        result += 31 * (rank - '1');
        result += 32 * (file - 'a');
        return result;
    }
}
