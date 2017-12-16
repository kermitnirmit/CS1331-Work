public class Test {
    public static void main(String[] args) throws InvalidSquareException {
        Square a1 = new Square('a', '5');
        System.out.println(a1);
        Square a9 = new Square('a', '9');
        System.out.println(a9);
        Square a = new Square("a");
        System.out.println(a);
        Square o3 = new Square("o3");
        System.out.println(o3);

    //     try {
    //         new Square("a1");
    //     } catch (InvalidSquareException e) {
    //         fail("InvalidSquareException for valid square: " + e.getMessage());
    //     }
    //     try {
    //         String invalidSquare = "a9";
    //         new Square(invalidSquare);
    //         fail("No InvalidSquareException for invalid square: " + invalidSquare);
    //     } catch (InvalidSquareException e) {
    //     // Success
    //     }
    // Square s = new Square("f7");
    // assertEquals('f', s.getFile());
    // assertEquals('7', s.getRank());
    // Square s2 = new Square('e', '4');
    // assertEquals("e4", s2.toString());
    }
}
