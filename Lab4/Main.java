/**
 * Assignment 4
 * Kehsin Yu
 * 002747728
 * Section 08
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Creating an object of the WeightedGrades class.
        WeightedGrades wg = new WeightedGrades();

        // Get user input of number of assignment.
        System.out.println("Enter number of assignments:");
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();

        // Get user input of total points of assignments.
        System.out.println("Enter total point of " + arraySize + " assignments:");
        String[] totalPoint = wg.getUserInput();
        ArrayList<Integer> totalPointArr = new ArrayList<>();
        for (String i : totalPoint) {
            totalPointArr.add(Integer.parseInt(i));
        }
        // If the input number of total points of assignments is not matched to the number of assignments, exit the system.
        if (arraySize != totalPointArr.size()){
            System.out.println("ERROR! The number of entered total points of assignments is not matched. Please start over again.");
            System.exit(0);
        }

        // Get user input of earned points of assignments.
        System.out.println("Enter earned point of " + arraySize + " assignments:");
        String[] earnedPoint = wg.getUserInput();
        ArrayList<Integer> earnedPointArr = new ArrayList<>();
        for (String i : earnedPoint) {
            earnedPointArr.add(Integer.parseInt(i));
        }
        if (arraySize != earnedPointArr.size()){
            System.out.println("ERROR! The number of entered earned points of assignments is not matched. Please start over again.");
            System.exit(0);
        }

        // Get user input of assignment percents.
        System.out.println("Enter " + arraySize + " assignment percents (%):");
        String[] percent = wg.getUserInput();
        ArrayList<Double> percentArr = new ArrayList<>();
        for (String i : percent) {
            percentArr.add(Double.valueOf(i));
        }
        if (arraySize != percentArr.size()){
            System.out.println("ERROR! The number of entered assignment percents is not matched. Please start over again.");
            System.exit(0);
        }

        // Calculate total weighted grade by looping through array of total point, earned points and assignment percentage.
        for(int i = 0; i < arraySize; i ++) {
            wg.setPointTotal(totalPointArr.get(i));
            wg.setEarnedPoints(earnedPointArr.get(i));
            wg.setAssignmentPercent(percentArr.get(i));
            wg.setTotalWeightedGrade(wg.getPointTotal(), wg.getEarnedPoints(), wg.getAssignmentPercent());
        }

        System.out.println("===== output ===== ");
        System.out.println("Total Grade = " + wg.getTotalWeightedGrade());
        System.out.println("Letter Grade = " + wg.letterGrade(wg.getTotalWeightedGrade()));
    }
}