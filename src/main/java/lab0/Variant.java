package lab0;

// Variant - 22

public class Variant {

    /**
     *
     * @param n integer number
     * @return factorial of n
     * */
    public static int fact(int n){
        if (n == 0)
            return 1;
        else
            return n * fact(n - 1);
    }

    public enum GRADE{

        BAD, UNSATISFYING, SATISFYING, GOOD, EXCELLENT

    }

    /**
     *
     * @param k is square side
     * @return perimeter
     */
    /*public int inputOutputTask(int k) {
        return 0;
    }*/


    /**
     *
     * @param n time in seconds
     * @return seconds passed since last hour
     */

    public int integerNumbersTask(int n) {

        assert(n >= 0): "Time can't be negative number!";

        return n % 3600;

    }

    /**
     *
     * @param n integer number of 3 digits
     * @return true, if digits of a given number form an increasing or decreasing sequence
     */
    public boolean booleanTask(int n) {
        assert (n >= 100 && n <= 999);
        if( ( (n / 100) < (n / 10 % 10) && (n / 10 % 10) < (n % 10) ) || ( (n / 100) > (n / 10 % 10) && (n / 10 % 10) > (n % 10) ) ){
            return true;
        }
        return false;
    }


    /**
     *
     * @param x integer coordinate
     * @param y integer coordinate
     * @return coordinate quarter of point
     */
    public int ifTask(int x, int y) {
        assert (x != 0 && y != 0);
        if(x > 0 && y > 0){
            return 1;
        }else if(x < 0 && y > 0){
            return 2;
        }else if(x < 0 && y < 0){
            return 3;
        }else {
            return 4;
        }
    }


    /**
     *
     * @param k is enum number
     * @return grade represented k
     */
    public GRADE switchTask(int k) {

        assert(k >= 1 && k <= 5): "Enum number doesn't exist!";

        switch(k) {
            case 1: {
                return GRADE.BAD;
            }
            case 2: {
                return GRADE.UNSATISFYING;
            }
            case 3: {
                return GRADE.SATISFYING;
            }
            case 4: {
                return GRADE.GOOD;
            }
            case 5: {
                return GRADE.EXCELLENT;
            }
            default: {
                return null;
            }
        }

    }


    /**
     *
     * @param x double number
     * @return approximated value of exp(x)
     */
    public double forTask(double x, int n) {

        assert n > 0: "Argument should be more than 0";

        double sum = 0.0;

        for(int i = 0; i < n; i++){

            sum += Math.pow(x, i) / fact(i);

        }

        return sum;
    }

    /**
     *
     * @param n integer number
     * @return is prime number
     */
    public boolean whileTask(int n) {
        assert (n > 1): "Argument should be more than 1";
        if (n <= 1) return false;
        if (n <= 3) return true;

        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) return false;
            i++;
        }

        return true;
    }

    /**
     *
     * @param n number of elements in numbers array
     * @return array that consists of smallest and second-smallest numbers
     */
    public int[] minmaxTask(int n, int[] numbers) {
        assert n > 1 : "Argument should be more than 1";
        assert numbers.length == n : "Size of array doesn't match n number";

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (numbers[i] < smallest) {
                secondSmallest = smallest;
                smallest = numbers[i];
            } else if (numbers[i] < secondSmallest && numbers[i] != smallest) {
                secondSmallest = numbers[i];
            }
        }

        // Check if there are at least two distinct numbers in the array
        if (secondSmallest == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Array must have at least two distinct numbers");
        }

        return new int[]{smallest, secondSmallest};
    }


    /**
     *
     * @param arr number array
     * @param k lower border
     * @param l higher border
     * @return sum of all other numbers that doesn't match border
     */
    public double arrayTask(double[] arr, int k, int l) {

        assert(k < 1 || l > arr.length || k > l): "Wrong K and L";

        double sum = 0.0;

        for (int i = 0; i < arr.length; i++) {
            if (i < k - 1 || i > l - 1) {
                sum += arr[i];
            }
        }

        return sum;
    }

    /**
     *
     * @param mat matrix
     * @param m number of rows
     * @param n number of columns
     * @return sum of elements with pair cols
     */
    public int matrixTask(int[][] mat, int m, int n) {

        assert(mat.length == m && mat[0].length == n): "Dimensions doesn't match!";

        int sum = 0;

        for(int i=0; i<m; i++){
            for(int j=1; j<n; j+=2){
                sum += mat[i][j];
            }
        }

        return sum;

    }

    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}