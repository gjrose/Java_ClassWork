import java.util.Random;
import java.util.ArrayList;

/**
   This class generates permutations of a sequence of integers 
   1...length.
*/
public class PermutationGenerator
{
   /**
      Construct a PermutationGenerator object.
      @param length the length of the permutations generated
      by this generator.
   */
   public PermutationGenerator(int length)
   {
      generator = new Random();
      this.length = length;
   }

   /**
      Gets the next permutation.
      @return the array containing the next permutation
   */
   public int[] nextPermutation()
   {
	  Random rand = new Random();
      // "result" array will contain the permutation we return when finished.
      int[] result = new int[length];
      // "choices" arraylist will contain the remaining unused numbers
      ArrayList<Integer> choices = new ArrayList<Integer>();

      // Put the numbers 1 through "length" into the choices array
      for (int i = 0; i < length; i++)
      {
         int numChoice = i + 1; 
         choices.add(numChoice);
      }

      // Now randomly pick numbers from the choices array and put them
      // into the results array:
      // First, get the randomly chosen index between 0 and choices.length().
      // Use the index to get the number out of the choices arraylist, and
      // store that number into the result array at index i.
      // Finally, remove the used number from the choices arraylist.
      for (int i = 0; i < length; i++)
      {
    	 int pick = rand.nextInt(choices.size());
    	 result[i] = (choices.get(pick));
    	 choices.remove(pick);
      }

      return result;
   }
   
   private Random generator;
   private int length;
}
