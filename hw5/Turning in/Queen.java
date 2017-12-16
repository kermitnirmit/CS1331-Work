/**
 * Represents a Queen
 * @author nshah372
 * @version 2.0
 */
public class Queen extends Piece {
    private String algName = "Q";
    private String fName;
    /**
     * Constructor for a Queen
     * @param  color         [either WHITE or BLACK]
     */
    public Queen(Color color) {
        super(color);
    }
    @Override
    public String algebraicName() {
        return algName;
    }
    @Override
    public String fenName() {
        if (this.getColor() == Color.BLACK) {
            fName = "q";
        } else {
            fName = "Q";
        }
        return fName;
    }
    @Override
    public Square[] movesFrom(Square square) {
        Square[] allPossible = new Square[27];
        int place = 0;
        for (int i = '8'; i > '0'; i--) {
            for (int j = 'a'; j <= 'h'; j++) {
                if (Math.abs(i - square.getRank())
                    == Math.abs(j - square.getFile())) {
                    if (square.getRank() == i && square.getFile() == j) {
                        place = place;
                    } else {
                        allPossible[place] = new Square((char) j, (char) i);
                        place++;
                    }
                } else if (((i - square.getRank() == 0)
                        && (j - square.getFile() != 0))
                        || ((i - square.getRank() != 0)
                        && (j - square.getFile() == 0))) {
                    if (square.getRank() == i && square.getFile() == j) {
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
