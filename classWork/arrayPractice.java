public class arrayPractice{
    public static void main(String[] args) {
        int[]nums = {4,1,2,1};
        System.out.println(more14(nums));

        String [][] seats = new String[5][6];
        for(int r=0; r<seats.length; r++) {
            for (int c=0; c<seats[r].length;c++) {
                seats[r][c] = "Spongebob";
            }
        }
        for(int r=0; r<seats.length; r++) {
            for (int c=0; c<seats[r].length;c++) {
                System.out.print(seats[r][c]+ " ");
            }
            System.out.println();
        }
        //System.out.println(printSeats(seats));
    }
    public static boolean more14(int[] array) {
    int oneCount=0;
    int fourCount=0;
    for (int i=0;i<array.length;i++ ) {
        if (array[i]==1) {
            oneCount++;
        } else if (array[i]==4) {
            fourCount++;
        }
    }
    return oneCount>fourCount;
    /*if (oneCount>fourCount) {
        return true;
    } else{
        return false;
    } */
    }
    /*public static void printSeats(String[][] items) {
        for (int num : items) {
            for (int col :items[num] ) {

            }
        }
    } */
}
