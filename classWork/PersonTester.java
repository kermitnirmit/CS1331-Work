import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
public class PersonTester {
    public static void main(String[] args)  {
        List<Person> people  = Arrays.asList(
            new Person("Charles", "Dickens", 60),
            new Person("Lewis", "Carroll", 52),
            new Person("Charlotte", "Bronte", 73),
            new Person("Thomas", "Carlisle", 15),
            new Person("Matthew", "Arnold", 37)
        );
        System.out.println("Before sorting: ");
        System.out.println(people);

        // Collections.sort(people);
        // System.out.println("After sorting: ");
        // System.out.println(people);

        //lambda
        Collections.sort(people,  (a, b) -> a.getFirstName().compareTo(b.getFirstName()));

        System.out.println("After sorting by first name: ");
        System.out.println(people);
        //anon inner
        Collections.sort(people, new Comparator<Person>() {
            public int compare(Person o, Person o2) {
                return o.getLastName().compareTo(o2.getLastName());
            }
        });

        System.out.println("After Sorting by last name");
        System.out.println(people);

        // Collections.sort(people, Person::getAge);
        // System.out.println(people);
    }
}
