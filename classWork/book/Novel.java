public class Novel extends Book {
    private Genre genre;

    public Novel(String t, String a, int n, Genre g) {
        super(t,a,n);
        setGenre(g);
    }

     public Novel() {
        super();
        this.genre = Genre.GENERAL;

    }

    public String toString() {
        return "Title: " + getTitle() + " Genre: " + this.genre;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre g) {
        this.genre = g;
    }

    public boolean isLong() {
        return getNumPages() > 200;
    }
    @Override
    public boolean equals(Object other) {
        if (other == null) { return false; }
        if (other == this) { return true; }
        if (!(other instanceof Novel)) { return false; }
        Novel that = (Novel) other;
        return getTitle().equals(that.getTitle()) && getAuthor().equals(that.getAuthor());
    }
}
