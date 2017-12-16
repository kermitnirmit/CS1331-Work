import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class Exceptions {
    public static void main(String[] args) throws FileNotFoundException {
        // method1(); // prints caught exception only
        // method2(); // needs the main method to also handle the exception
    }
    public void method1() {
        try {
            Scanner scan = new Scanner(new File("p.txt"));
            System.out.println("method1"); // doesnt get printed
        } catch (FileNotFoundException e) {
            System.out.println("caught exception "+ e.getMessage());
        }
    }
    public void method2() throws FileNotFoundException {
        try {
            Scanner scan = new Scanner(new File("p.txt"));
            System.out.println("method1"); // doesnt get printed
        } catch (FileNotFoundException e) {
            System.out.println("caught exception "+ e.getMessage());
        }
    }
}
