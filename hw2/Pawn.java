public class Pawn extends Piece {
    private String algName = "";
    private String fName;
    public Pawn (Color color) {
        super(color);
    }
    public String algebraicName(){
        return algName;
    }

    public String fenName(){
        if (this.getColor()== Color.BLACK) {
            fName = "p";
        } else {
            fName = "P";
        }
        return fName;
    }

    public Square[] movesFrom (Square square){
        int startingRank = square.getRank();
        Square[] allPossible = new Square[2];
        int place = 0;
        if (this.getColor() == Color.BLACK) {
            if (startingRank=='7') {
                allPossible[0] = new Square(square.getFile(),(char) (square.getRank()-1));
                place++;
                allPossible[1] = new Square(square.getFile(),(char) (square.getRank()-2));
                place++;
            } else if (startingRank=='1') {
            } else {
                    allPossible[0] = new Square(square.getFile(),(char) (square.getRank()-1));
                    place++;
                }
        } else {
            if (startingRank=='2') {
                allPossible[0] = new Square(square.getFile(),(char) (square.getRank()+1));
                place++;
                allPossible[1] = new Square(square.getFile(),(char) (square.getRank()+2));
                place++;
            } else if (startingRank=='8') {
            } else {
                    allPossible[0] = new Square(square.getFile(),(char) (square.getRank()+1));
                    place++;
                }
            }
        Square[] possibles = new Square[place];
        for (int i = 0;i < possibles.length ;i++) {
            possibles[i]=allPossible[i];
        }
        // for(int i = 0; i<possibles.length; i++) {
        //     System.out.print(possibles[i]+ " ");
        // }
        return possibles;
    }
}
