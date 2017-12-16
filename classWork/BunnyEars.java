public class BunnyEars {
    public static void main(String[] args) {
        System.out.println(bunnyEars(10));
        System.out.println(sumDigits(23));
        System.out.println(sumDigits(10023));
    }

    public static int bunnyEars( int b) {
        if(b<=0) {
            return 0;
        } else {
            return 2+ bunnyEars(b-1);
        }
    }
    public static int sumDigits( int n) {
        if (n<10 && n>=0) {
            return n;
        } else {
            return n%10 + sumDigits(n/10);
        }
    }
}
