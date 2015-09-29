import java.util.ArrayList;
import java.util.Scanner;

public class GradeKeeper {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		// Create the list of students
		ArrayList<StudentAssignments> students = new ArrayList<StudentAssignments>();
		// Replace the hard-coded student names with strings read
		// using a while loop. Use each student name to create a new
		// StudentAssignments object for the student, and add the new
		// StudentAssignments object to the students ArrayList.
		System.out.println("Enter student name, or DONE if finished: ");
		boolean done = false;
		while(!done){
			String stdName = stdin.next();					
			if(stdName.equals("DONE")){						
				done = true;
				}
			else{
				students.add(new StudentAssignments(stdName));
				}
		}
		
		// Create the list of assignment names
		ArrayList<String> assignmentNames = new ArrayList<String>();
		// Replace the hard-coded assignment names with strings read
		// using a while loop. Add each assignment name to the
		// assignmentNames ArrayList.
		System.out.println("Enter assignment name, or DONE if finished: ");
		boolean dDone = false;
		while(!dDone){	
			String stdHW = stdin.next();
			if(stdHW.equals("DONE")){						
				dDone = true;
				}
			else{
				assignmentNames.add(stdHW);
				}
		}

		// Set each student's assignments and scores.
		// Replace with a for loop over the assignments (use
		// assignmentNames.size() to determine the number of assignment
		// names entered by the user) containing a nested for loop over
		// the students (use students.size() to determine the number of
		// students entered by the user).
		// Prompt the user to enter the score for the assignment
		// and student, and use the StudentAssignment's recordGrade()
		// method to add the score to the student.
		for(int i = 0; i < students.size(); i++){
			for(int x = 0; x < assignmentNames.size(); x++){
				System.out.print("Enter score for "+ students.get(i).getStudentName());
				System.out.println(". "+ assignmentNames.get(x) +": ");
				double stdScore = stdin.nextDouble();		
				students.get(i).recordGrade(assignmentNames.get(x), stdScore);
		}
		}

	
		for (int y = 0; y < students.size(); y++) {
			System.out.println(students.get(y).toString());
		}
	}


}

