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
    public abstract String algebraicName();

    public abstract String fenName();

    public abstract Square[] movesFrom(Square square);
}
