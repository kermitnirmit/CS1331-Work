public class Loopy {
    public static void main(String[] args) {
        /*for (int i = 0;i<10 ;i++ ) {
            System.out.println(i);
        }
        String word = "RESPECT";
        int l = word.length();
        for (int i=0;i<l;i++ ) {
            char a=word.charAt(i);
            System.out.print(a);
        } */
        System.out.println(numRange(12,true));
        System.out.println(numRange(12,false));
        System.out.println(numRange(6,true));
        System.out.println(numRange(6,false));
    }
    public static boolean numRange (int num, boolean outsideMode) {
        if(outsideMode){
            if(num>=10||num<=1){
                return true;
            } else{
                return false;
            }
        } else{
            if(num>=1 && num<=10){
                return true;
            } else {
                return false;
            }
        }
    }
}
