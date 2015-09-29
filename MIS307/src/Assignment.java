/**
 * Keep the assignment name and score for an assignment.
 * @author ghelmer
 *
 */
public class Assignment {
	private double score;
	private String name;
	
	/**
	 * Create the new assignment.
	 * @param name - Name of the assignment
	 * @param score - Score earned for the assignment
	 */
	public Assignment(String name, double score) {
		this.name = name;
		this.score = score;
	}
	
	/**
	 * Get the assignment's score.
	 * @return score
	 */
	public double getScore() {
		return score;
	}
	
	/**
	 * Get the assignment's name.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return a string representing the assignment and score.
	 */
	public String toString() {
		return name + ": " + score;
	}
}
