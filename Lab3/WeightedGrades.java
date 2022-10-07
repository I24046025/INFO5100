import java.util.Scanner;

/**
 * Assignment 3
 * Kehsin Yu
 * 002747728
 * Section 08
 */
public class WeightedGrades {
    private int pointTotal;
    private int earnedPoints;
    private double assignmentPercent;

    // Initialize total weighted grade as zero.
    private double totalWeightedGrade = 0;

    /**
     * @Description get user input value and separated by space and comma
     * @return String[]
     */
    public String[] getUserInput(){
        Scanner sc = new Scanner(System.in).useDelimiter("[,\n]");
        String line = sc.nextLine().replaceAll(" ", "");
        String[] temp = line.split(",");
        return temp;
    }

    /**
     * @return total point of assignment
     */
    public int getPointTotal(){
        return pointTotal;
    }

    /**
     * @Description set total point of assignment
     * @param pointTotal
     */
    public void setPointTotal(int pointTotal){
        this.pointTotal = pointTotal;
    }

    /**
     * @return get student's earned points of assignment
     */
    public int getEarnedPoints() {
        return earnedPoints;
    }

    /**
     * @Description set student's earned points of assignment
     * @param earnedPoints
     */
    public void setEarnedPoints(int earnedPoints){
        this.earnedPoints = earnedPoints;
    }

    /**
     * @return percentage of assignment (%)
     */
    public double getAssignmentPercent(){
        return assignmentPercent;
    }

    /**
     * @Description set percentage of assignment
     * @param assignmentPercent
     */
    public void setAssignmentPercent(double assignmentPercent){
        this.assignmentPercent = assignmentPercent;
    }

    /**
     * @return total weighted grade
     */
    public double getTotalWeightedGrade(){
        return totalWeightedGrade;
    }

    /**
     * @Description set student's total weighted garde
     * @param totalPoints
     * @param earnedPoints
     * @param percentage
     */
    public void setTotalWeightedGrade(int totalPoints, int earnedPoints, double percentage) {
        this.totalWeightedGrade = totalWeightedGrade + ((float)earnedPoints/totalPoints)*percentage;
    }

    /**
     * @Description get the letter grade based on the weighted grade
     * @param totalWeightedGrade
     * @return letter grade
     */
    public char letterGrade(double totalWeightedGrade){
        if(totalWeightedGrade >= 90) {
            return 'A';
        } else if(totalWeightedGrade >= 80) {
            return 'B';
        } else if(totalWeightedGrade >= 70) {
            return 'C';
        } else if(totalWeightedGrade >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}