/**
 * Represents a Bishop
 * @author nshah372
 * @version 2.0
 */
public class Bishop extends Piece {
    private String algName = "B";
    private String fName;
    /**
     * Constructor for a Bishop
     * @param  color         [either WHITE or BLACK]
     */
    public Bishop(Color color) {
        super(color);
    }
    @Override
    public String algebraicName() {
        return algName;
    }
    @Override
    public String fenName() {
        if (this.getColor() == Color.BLACK) {
            fName = "b";
        } else {
            fName = "B";
        }
        return fName;
    }
    @Override
    public Square[] movesFrom(Square square) {
        Square[] allPossible = new Square[13];
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
