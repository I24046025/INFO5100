/**
 * @Description Private attributes created and then public methods.
 * Assignment 2
 * Kehsin Yu
 * 002747728
 * Section 08
 */
public class WeightedGrades {
    private int pointTotal;
    private int earnedPoints;
    private double assignmentPercent;
    private double totalWeightedGrade;

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
    public int getEarnedPoints(){
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
     * @param totalWeightedGrade
     */
    public void setTotalWeightedGrade(double totalWeightedGrade) {
        this.totalWeightedGrade = totalWeightedGrade;
    }
}

