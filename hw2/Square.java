public class Square {
    private char file;
    private char rank;

    public Square (char file, char rank) {
        this.file = file;
        this.rank = rank;
    }

    public Square (String name) {
        this.file = name.charAt(0);
        this.rank = name.charAt(1);
    }


    public String toString () {
        return file+""+rank;
    }

    public boolean equals (Object other) {
        if (null == other) { return false; }
        if (this == other) { return true; }
        if (!(other instanceof Square)) { return false; }
        Square that = (Square) other;
        return this.file==that.file && this.rank==that.rank;
    }

	public char getFile() {
		return file;
	}

	public char getRank() {
		return rank;
	}
}
