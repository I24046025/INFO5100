/**
 * Assignment 2
 * Kehsin Yu
 * 002747728
 * Section 08
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Creating an object of the WeightedGrades class.
        WeightedGrades wg = new WeightedGrades();

        // Get input of total point.
        System.out.print("Enter point total:");
        Scanner sc = new Scanner(System.in);
        wg.setPointTotal(sc.nextInt());

        // Get input of student's earned points.
        System.out.print("Enter earned points:");
        sc = new Scanner(System.in);
        wg.setEarnedPoints(sc.nextInt());

        // Get input of assignment percent (%).
        System.out.print("Enter assignment percent (%):");
        sc = new Scanner(System.in);
        wg.setAssignmentPercent(sc.nextDouble());

        // Calculate the weighted grade.
        double weighted =((float)wg.getEarnedPoints()/wg.getPointTotal())*wg.getAssignmentPercent();
        wg.setTotalWeightedGrade(weighted);

        System.out.println("===== output ===== ");
        System.out.println("Point Total = " + wg.getPointTotal());
        System.out.println("Earned Points = " + wg.getEarnedPoints());
        System.out.println("Assignment % = " + wg.getAssignmentPercent());
        System.out.printf("Total Weighted grade = %.3f", wg.getTotalWeightedGrade());
    }
}
