public class ArrayPractice1 {

    public static void main(String[] args) {
        //declare an array of 25 ints called nums and allocate the memory
        int[] nums = new int[25]; // contains 25 zeroes
        double[] scores;
        int numstudents = 143;
        scores = new double[numstudents];
        char[] letters = {'A','B','C','D','F'};

        //System.out.println(nums);
        System.out.println(nums[0]);
        System.out.println(nums[24]);

        for (int i = 0; i < nums.length; i++) {
            nums[0] += 1;
            System.out.println(nums[i]);
        }

        for (int i = 0; i < nums.length; i+=2) {
            nums[i] = nums[i] + 25;
        }

        for (int anumber:nums) {
            anumber += 1;
            System.out.println(anumber);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        printMyArray(nums);
        int[] testnums = {4,1,2,1};
        System.out.println(more14(testnums));
        //System.out.println(printNumbers(1,2,4,5));

    }

    public static void printMyArray(int[] stuff) {
        for (int i = 0; i < stuff.length; i++) {
            System.out.println(stuff[i]);
        }
    }
    public static boolean more14(int[] stuff) {
        int count1 = 0;
        int count4 = 0;
        for (int i = 0; i < stuff.length; i++) {
            if (stuff[i]==1) {
                count1++;
            }
            if (stuff[i]==4)  {
                count4++;
            }
        }
        return count1>count4;
    }
    public static void printNumbers(double ... nums) {
        for (double anumber : nums) {
            System.out.println(anumber);
        }
    }
}
