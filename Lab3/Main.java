/**
 * Assignment 3
 * Kehsin Yu
 * 002747728
 * Section 08
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Creating an object of the WeightedGrades class.
        WeightedGrades wg = new WeightedGrades();

        // Get user input og total points of 8 assignments.
        System.out.println("Enter total point of 8 assignments:");
        String[] totalPoint = wg.getUserInput();
        ArrayList<Integer> totalPointArr = new ArrayList<Integer>();
        for (String i : totalPoint) {
            totalPointArr.add(Integer.parseInt(i));
        }

        // Get user input of earned points of 8 assignments.
        System.out.println("Enter earned point of 8 assignments:");
        String[] earnedPoint = wg.getUserInput();
        ArrayList<Integer> earnedPointArr = new ArrayList<Integer>();
        for (String i : earnedPoint) {
            earnedPointArr.add(Integer.parseInt(i));
        }

        // Get user input of assignment percents.
        System.out.println("Enter 8 assignment percents (%):");
        String[] percent = wg.getUserInput();
        ArrayList<Double> percentArr = new ArrayList<Double>();
        for (String i : percent) {
            percentArr.add(Double.valueOf(i));
        }

        // Calculate total weighted grade by looping through array of total point, earned points and assignment percentage.
        for(int i = 0; i < 8; i ++) {
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