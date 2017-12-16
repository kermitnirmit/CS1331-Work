public class RecursivePractice {
    public static void main(String[] args) {
        recCountDown(10);
        //recCountDown(20000);
        System.out.println(sumUp(10));
        System.out.println(sumUp(100));

    }
    public static void recCountDown(int n) {
        if (n<=0) {
            System.out.println(n);
        } else {
            System.out.print(n + " ");
            recCountDown(n-1);
            // System.out.print(n + " ");
        }
    }
    public static int sumUp(int n) {
        if (n<=1) {
            return  1;
        } else {
            return n + sumUp(n-1);
        }
    }
}
