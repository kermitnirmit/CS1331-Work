public class Rook extends Piece {
    private String algName = "R";
    private String fName;
    public Rook (Color color) {
        super(color);
    }
    public String algebraicName(){
        return algName;
    }

    public String fenName(){
        if (this.getColor()== Color.BLACK) {
            fName = "r";
        } else {
            fName = "R";
        }
        return fName;
    }

    public Square[] movesFrom (Square square){
        Square[] possibles = new Square[14];
        int place =0;
        for (int i = '8';i > '0';i--) {
            for (int j = 'a'; j <= 'h';j++ ) {
                if (((i-square.getRank()== 0) && (j-square.getFile()!=0))|| ((i-square.getRank()!=0) && (j-square.getFile()==0))) {
                    possibles[place] = new Square((char) j,(char) i);
                    place++;
                }
            }
        }
        return possibles;
    }
}
