public abstract class Piece {
    private Color color;
    /**
    * Default Piece constructor
    */
    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract String algebraicName();

    public abstract String fenName();

    public abstract Square[] movesFrom(Square square);
}
