public class DobermanTester {
    public static void main(String[] args) {
        Doberman dob1 = new Doberman("Michael");
        System.out.println(dob1);
        Doberman d = dob1;
        System.out.println(d);
        d.setName("Jackson");
        System.out.println(dob1);
        System.out.println(Doberman.getDobieCount());
    }
}
