import java.util.ArrayList;
import java.util.Collections;

public class CollectionPractice {
    static class DobyNameComparator implements Comparator<Doberman> {
        public int compare(Doberman a, Doberman b) {
            System.out.println(a.getName() + " " +b.getName());
            return a.getName().compareTo()(b.getName();
        }
    }
    public static void main(String[] args) {
        ArrayList<String> pets = new ArrayList<>();
        pets.add("rabbit");
        pets.add("cat");
        pets.add("dog");
        String mypet = pets.get(0);
        Collections.sort(pets); //would not work if String didnt implement comparable
        System.out.println(pets);


        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book("Moby Dick", "melville", 822));
        books.add(new Book("It", "King", 389));
        books.add(new Book("Emma", "Austen", 522));
        books.add(new Book("1922", "King", 189));
        books.add(new Book("Silas Marner", "Eliot", 700));
        System.out.println("reached");
        Collections.sort(books);
        // sorts in natural ordering - number of pages
        // this sort method actually changes the ArrayList
        System.out.println(books);
        System.out.println("new sort");
        Collections.sort(books, new AuthorComparator());
        // sorts in natural ordering - number of pages
        // this sort method actually changes the ArrayList
        System.out.println(books);

        ArrayList<Doberman> dogs = new ArrayList<>();
        dogs.add(new Doberman());
        dogs.add(new Doberman("Blackie"));
        dogs.add(new Doberman("Sweetie"));
        dogs.add(new Doberman("Michael"));
        // dogs.add(new Doberman("Michael"));
        System.out.println("dogs sort");
        Collections.sort(dogs, new DobieComparator());
        System.out.println(dogs);
    }
}
