import java.util.Iterator;

public class Range implements Iterator<Integer> {
    private int start;
    private int stop;
    private int step;
    public Range(int start, int stop, int step){
        this.start = start;
        this.stop = stop;
        this.step = step;
    }
    public boolean hasNext() {
        return true;
    }
    public Integer next() {
        
    }
    public static void main(String[] args) {
        for(int i:new Range(0,20,2)) {
            System.out.println(i);
        }
    }
}
