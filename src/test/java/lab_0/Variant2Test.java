package lab_0;


public class Variant2Test {

    public static void main(String[] args) {
        // Test Task 1
        System.out.println("Task 1: " + Variant2.calculateFullTons(2500));

        // Test Task 2
        System.out.println("Task 2: " + Variant2.isOdd(7));

        // Test Task 3
        System.out.println("Task 3: " + Variant2.modifyBasedOnSign(-5));

        // Test Task 4
        System.out.println("Task 4: " + Variant2.getGradeDescription(3));

        // Test Task 5
        System.out.println("Task 5:");
        Variant2.printIntegersInRange(3, 8);

        // Test Task 6
        System.out.println("Task 6: " + Variant2.calculateSegments(15, 4));

        // Test Task 7
        int[][] rectangles = {{2, 3}, {4, 5}, {1, 8}};
        System.out.println("Task 7: " + Variant2.findMinRectangleArea(rectangles));

        // Test Task 8
        int[] powersOfTwo = Variant2.generatePowersOfTwo(5);
        System.out.print("Task 8: ");
        for (int power : powersOfTwo) {
            System.out.print(power + " ");
        }
        System.out.println();

        // Test Task 9
        int[][] matrix = Variant2.generateMatrix(3, 4);
        System.out.println("Task 9:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
