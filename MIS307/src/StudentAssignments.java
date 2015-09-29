import java.util.ArrayList;

/**
 * StudentAssignments: Keep all the assignments for a student.
 * 
 * @author ghelmer
 *
 */
public class StudentAssignments {
  private String name;
  private ArrayList<Assignment> assignments;
  private int numAssignments;
  
  /**
   * Create a new grade record for the named student.
   * @param name - Name for student
   */
  public StudentAssignments(String name) {
      this.name = name;
      numAssignments = 0;
      assignments = new ArrayList<Assignment>();
  }
  
  /**
   * Record a grade for the student.
   * @param assignmentName - Name for the assignment
   * @param score - Score given for the assignment
   */
  public void recordGrade(String assignmentName, double score)
  {
      assignments.add(new Assignment(assignmentName, score));
  }

  /**
   * Get the total score for the student.
   * @return Total
   */
  public double getTotalScore() {
      double totalScore = 0;
      int i;
      for (i = 0; i < assignments.size(); i++)
	  totalScore += assignments.get(i).getScore();
      return totalScore;
  }
  
  /**
   * Get the number of assignments assigned to this student.
   * @return Number of assignments
   */
  public double getNumAssignments() {
      return assignments.size();
  }

 /**
   * Get the name of this student.
   * @return Student name
   */
  public String getStudentName() {
      return name;
  }

  /**
   * Get the average grade for this student.
   * @return computed average score
   */
  public double getAveScore() {
      if (assignments.size() == 0) return 0;
      return getTotalScore() / assignments.size();
  }
  
  /**
   * Get a String representing this student and all the assignments.
   */
  public String toString() {
      int i;
      String r = "";
	  
      // Put the name into the string.
      r = r + name + "\n";
	  
      // Put each assignment into the string.
      for (i = 0; i < assignments.size(); i++) {
	  r = r + "  " + assignments.get(i).toString() + "\n";
      }
	  
      if (assignments.size() > 0) {
	  // Put the total and average score into the string.
	  r = r + "Total score: " + getTotalScore() + " Average: " +
	      String.format("%.2f", getAveScore()) + "\n";
      } else {
	  r = r + "No assignments recorded\n";
      }
      return r;
  }
}
