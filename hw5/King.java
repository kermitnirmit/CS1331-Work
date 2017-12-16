public class King extends Piece {
    private String algName = "K";
    private String fName;
    public King(Color color) {
        super(color);
    }
    /**
    * Returns value of algName
    * @return
    */
    public String algebraicName() {
        return algName;
    }
    /**
    * Returns value of fenName
    * @return
    */
    public String fenName() {
        if (this.getColor() == Color.BLACK) {
            fName = "k";
        } else {
            fName = "K";
        }
        return fName;
    }
    /**
    * @return Creates an array of all moves. Then gets trmmed to the array
    *         that has no nulls
    */
    public Square[] movesFrom(Square square) {
        Square[] allPossible = new Square[8];
        int place = 0;
        for (int i = '8'; i > '0'; i--) {
            for (int j = 'a'; j <= 'h'; j++) {
                if (Math.abs(i - square.getRank()) < 2
                        && Math.abs(j - square.getFile()) < 2) {
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
