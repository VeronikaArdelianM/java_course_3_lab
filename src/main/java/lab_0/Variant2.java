package lab_0;

public class Variant2 {

    /**
     * Task 1: Calculate the number of full tons in the given mass.
     *
     * @param mass The mass in kilograms.
     * @return The number of full tons in the given mass.
     */
    public static int calculateFullTons(int mass) {
        return mass / 1000;
    }

    /**
     * Task 2: Check if the given number is odd.
     *
     * @param number The integer to be checked.
     * @return True if the number is odd, false otherwise.
     */
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    /**
     * Task 3: Modify the given integer based on its sign.
     *
     * @param number The integer to be modified.
     * @return The modified integer.
     */
    public static int modifyBasedOnSign(int number) {
        if (number > 0) {
            return number + 1;
        } else {
            return number - 2;
        }
    }

    /**
     * Task 4: Get the description of the grade based on the given number.
     *
     * @param grade The grade number.
     * @return The description of the grade or "error" if the grade is outside the range 1-5.
     */
    public static String getGradeDescription(int grade) {
        return switch (grade) {
            case 1 -> "poor";
            case 2 -> "unsatisfactory";
            case 3 -> "satisfactory";
            case 4 -> "good";
            case 5 -> "excellent";
            default -> "error";
        };
    }

    /**
     * Task 5: Generate and print integers between A and B in ascending order.
     *
     * @param a The starting integer.
     * @param b The ending integer.
     */
    public static void printIntegersInRange(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nCount: " + (b - a + 1));
    }

    /**
     * Task 6: Calculate the number of segments of length B in a segment of length A.
     *
     * @param a The length of the main segment.
     * @param b The length of the sub-segment.
     * @return The number of sub-segments that can fit in the main segment.
     */
    public static int calculateSegments(int a, int b) {
        int count = 0;
        while (a >= b) {
            a -= b;
            count++;
        }
        return count;
    }

    /**
     * Task 7: Find the minimum area of a rectangle from a given set of rectangles.
     *
     * @param rectangles An array of rectangle sides represented as pairs of numbers.
     * @return The minimum area of a rectangle.
     */
    public static int findMinRectangleArea(int[][] rectangles) {
        int minArea = Integer.MAX_VALUE;
        for (int[] rectangle : rectangles) {
            int area = rectangle[0] * rectangle[1];
            if (area < minArea) {
                minArea = area;
            }
        }
        return minArea;
    }

    /**
     * Task 8: Generate an array containing powers of two from 2^1 to 2^N.
     *
     * @param n The number of elements in the array.
     * @return The array containing powers of two.
     */
    public static int[] generatePowersOfTwo(int n) {
        int[] powersOfTwo = new int[n];
        for (int i = 0; i < n; i++) {
            powersOfTwo[i] = (int) Math.pow(2, i + 1);
        }
        return powersOfTwo;
    }

    /**
     * Task 9: Generate a matrix with columns containing multiples of 5.
     *
     * @param m The number of rows.
     * @param n The number of columns.
     * @return The generated matrix.
     */
    public static int[][] generateMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 5 * (j + 1);
            }
        }
        return matrix;
    }
}
