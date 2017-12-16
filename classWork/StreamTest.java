import java.util.Arrays;
import java.util.List;
public class StreamTest {

    public static void main(String[] args) {
        List<String> myList =
        Arrays.asList("a1", "a2", "b1", "c1", "c2");
        //doing something with a predicate and a lambda idk lmao 
        myList
            .stream()
            .filter(s -> s.startsWith("c"))
            // .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
    }
}
