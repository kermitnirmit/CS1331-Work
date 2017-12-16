public class day3ClassCode{
    public static void main(String[] args) {
        String name = "Georgia Tech";
        String name2 = new String("Georgia Tech");
        String name3;
        name3 = "Georgia Tech";
        String name4= name + name2+name3;
        String name5= name4+42;
        System.out.println(name);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
        System.out.println(name5);
        //strings are immutable
        // name="Tech"; just makes a whole new string not changing one letter
        name="Tech";
        String shortName = name.substring(0,3);//0 to 2
        System.out.println(shortName);
        int place=name.indexOf("e");
        System.out.println(place);
        name=name.toUpperCase();
        System.out.println(name);
        int length = name.length();
        System.out.println(length);
        int compared = name.compareTo(name2);
        System.out.println(compared);
        boolean comparison = name.equals(name2);
        System.out.println(comparison);
        String empty = "";
        String emptyalso = null;
        System.out.println(emptyalso.length()); //null doesnt have a length
    }
}
