import java.util.*;
public class Test {
  public static void main(String[] args) {
    // for (int i = 0; i < 2; i++) {
    //   System.out.print(i + " ");
    //   try {
    //     System.out.println(1 / 0);
    //   }
    //   catch (Exception ex) { //it is handled by not doing anything lmao so nothing gets crashed
    //   }
    // }
    /**
     * Lists below
     */
    List<Integer> list = new ArrayList<Integer>();
    list.add(42);
    list.add(24);
    list.add(42);
    list.remove(new Integer(42)); //removes the first 42
    System.out.println(list);
    /**
     * Sets below
     */
    Set<String> set = new HashSet<String>();
    set.add("one");
    set.add("one");
    set.add("two");
    set.add("two");

    System.out.println(set.size());
    System.out.println(set);
    /**
     * Maps are below
     */
    Map<String, String> map = new HashMap();
    map.put("GA", "ATL");
    map.put("FL", "MIA");
    // map.put("GA", "MIA");
    System.out.println(map);
  }
}
