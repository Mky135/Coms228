public class testClass {

    //Tests if doing for i to get neighboring cells
    public static void main(String[] args) {
        int[][] nums = new int[3][3];
        int row = 1;
        int col = 1;
        int count = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                nums[row + i][col + j] = count;
                count++;
            }
        }
        for (int[] ints: nums
             ) {
            for (int i: ints
                 ) {
                print(i);
            }
        }
    }

    public static void print(Object object)
    {
        System.out.println(object);
    }
}
