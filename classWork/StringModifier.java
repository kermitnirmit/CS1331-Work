public class StringModifier {
    public interface Modifier {
        String modify(String s);
    }
    public static String change(String s, Modifier m) {
        return m.modify(s);
    }
    public static void main(String[] args) {
        String s = "YO LAMBDA";
        //using lambda expression
        // String newString = change(s, (x) -> x.toLowerCase());
        //
        //
        //using an anonymous inner class
        // String newString = change(s, new Modifier() {
        //     public String modify(String x) {
        //         return x.toLowerCase();
        //     }
        // });

        //using an inner class
        class ModifyString {
            public String modify(String x) {
                return  x.toLowerCase();
            }
        }
        ModifyString ms = new ModifyString();
        String newString = ms.modify(s);

        System.out.println(newString);
    }
}
