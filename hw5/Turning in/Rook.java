/**
 * Represents a Rook
 * @author nshah372
 * @version 2.0
 */
public class Rook extends Piece {
    private String algName = "R";
    private String fName;
    /**
     * Constructor for a Rook
     * @param  color         [either WHITE or BLACK]
     */
    public Rook(Color color) {
        super(color);
    }
    @Override
    public String algebraicName() {
        return algName;
    }
    @Override
    public String fenName() {
        if (this.getColor() == Color.BLACK) {
            fName = "r";
        } else {
            fName = "R";
        }
        return fName;
    }
    @Override
    public Square[] movesFrom(Square square) {
        Square[] allPossible = new Square[14];
        int place = 0;
        for (int i = '8'; i > '0'; i--) {
            for (int j = 'a'; j <= 'h'; j++) {
                if (((i - square.getRank() == 0)
                        && (j - square.getFile() != 0))
                        || ((i - square.getRank() != 0)
                        && (j - square.getFile() == 0))) {
                    if (square.getRank() == i
                        && square.getFile() == j) {
                        place = place;
                    } else {
                        allPossible[place] = new Square((char) j, (char) i);
                        place++;
                    }
                }
            }
        }
        Square[] possibles = new Square[place];
        for (int i = 0; i < possibles.length; i++) {
            possibles[i] = allPossible[i];
        }
        return possibles;
    }
}
