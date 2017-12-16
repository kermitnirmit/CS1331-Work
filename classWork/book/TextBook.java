public class TextBook extends Book {
    private String subject;

    public TextBook(String t, String a, int n, String s) {
        super(t,a,n);
        setSubject(s);
    }

     public TextBook() {
        super();
        this.subject = "unknown";
    }

    public String toString() {
        return "Title: " + getTitle() + " Subject: " + this.subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String g) {
            this.subject = g;
    }

    public int getNumPages() {
        return 99;
    }

    @Override
    public boolean isLong() {
       return getNumPages() > 900;
    }

}