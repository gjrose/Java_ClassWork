package pa6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;
public class SpellChecker 
{
	public static void main(String[] args) throws FileNotFoundException
 {
		Scanner stdin = new Scanner(System.in);
		ArrayList<String> dData = fileToList("dictionary.txt");
		System.out.println("Enter the name of a file that is to be spell checked.");
		String fileName = stdin.next();
		File f = new File(fileName);
	
		ArrayList<String> fData = fileToList(fileName); //input data processing
		ArrayList<String> misData = misSpelledWords(fData, dData); //misspelled word processing
		
		for(int i = 0; i<misData.size(); i++) 
		{
		System.out.println(misData.get(i)+ ": " +suggestedAlternatives(misData.get(i), dData)); //prints words from misSpelledWords list and their suggested alternatives
		}
				
		
		//printList(misData);
		
	
 }
	

	public static ArrayList<String> fileToList(String fileName) throws FileNotFoundException{ //converts file to Array List
		File f = new File(fileName);
		Scanner fileIn = new Scanner(f);
		ArrayList<String> data = new ArrayList<String>();
		while(fileIn.hasNext()){
		String word = fileIn.next();
		int n = word.length()-1;
		if(word.charAt(n) != ',' && word.charAt(n) != '.'){
		data.add(word);
		}
		else if(word.charAt(n) == ',' || word.charAt(n) == '.'){
		word = word.substring(0, n);
		data.add(word);
		}
		}
		return data;
	}
	public static boolean appears (String word, ArrayList<String> dictionaryList){ //determines if variable word appears in the dictionary list
		boolean result = false;
		String chkWord = "";
		String uWord = word.toUpperCase();
		for(int i = 0; i<dictionaryList.size(); i++){
			chkWord = dictionaryList.get(i);
			String upChkWord = chkWord.toUpperCase();
			dictionaryList.set( i ,upChkWord);
			if(uWord.equals(upChkWord)){
				result = true;
			}
		}
		return result;
	}
	public static ArrayList<String> misSpelledWords (ArrayList<String> dataList, ArrayList<String> dictionaryList){ //returns a list of every word from file that doesn't appear in dictionary
		ArrayList<String> misspelled = new ArrayList<String>();
		String lockUp = "";
		for(int i = 0; i<dataList.size(); i++){
			if(appears(dataList.get(i), dictionaryList)==false){
				lockUp = dataList.get(i);
				misspelled.add(lockUp);
		}
			lockUp="";
		}
		return misspelled;
	}
	public static boolean transposable (String word1, String word2){ //checks words for a 2 character difference
		boolean result = false;
		int diffsum = 0;
		String x = word1.toUpperCase();
		String y = word2.toUpperCase();
		if(x.length() == y.length()){
		for(int i = 0; i<=x.length()-1;i++)
		{
			if(x.substring(i,i+1) != y.substring(i,i+1))
			{
			diffsum = diffsum+1;
			}	
		}
		if(diffsum == 2){
			result = true;
		}
		}
		return result;	
		}
	public static boolean editDistanceOne(String word1, String word2) { //checks if word1 can be converted to word2 by a single operation
		String x = word1.toUpperCase();
		String y = word2.toUpperCase();
	
		int n = x.length();
		int m = y.length();
		int[][] M = new int[n+1][m+1];
		for(int i = 0; i<=n; i++)
			M[i][0] = i;
		for(int i = 0; i<=m; i++)
			M[0][i]  = i;
		int change = 0;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				if (x.charAt(i-1) == y.charAt(j-1)) 
					change = 0;
				else
					change = 1;
				M[i][j] = M[i-1][j]+1;
				
				if ((M[i][j-1]+1) < M[i][j])
					M[i][j] = M[i][j-1]+1;
				if (M[i-1][j-1]+change < M[i][j]) 
					M[i][j] = M[i-1][j-1]+change;
			}
		}
		return (M[n][m] <=1);
	}
	public static boolean alternate (String word1, String word2){ //checks if word1 can be an alternate for word2, using editDistanceOne and transposable methods
		boolean result = false;
		if(editDistanceOne(word1,word2) == true || transposable(word1,word2) == true){
			result = true;
		}
		return result;
	}
	public static ArrayList<String> suggestedAlternatives (String misSpelledWord, ArrayList<String> dictionaryList){ //adds words to list that meet true condition under alternate method
		ArrayList<String> sugWords = new ArrayList<String>();
		String dWord ="";
		int wordSum = 0;
		
		for(int i=0; i<dictionaryList.size(); i++)
		{
				if(alternate(misSpelledWord, dictionaryList.get(i))==true)
				{
				dWord = dictionaryList.get(i);
				sugWords.add(dWord);
				wordSum = wordSum +1;
				}
		}
				if (wordSum == 0)
				{
				sugWords.add("No Alternate Words Found");
				}
				dWord ="";
		
		return sugWords;
	}
	public static String printList(ArrayList<String> list) //prints array lists for testing
	{
		String print = "";
		for(int i = 0; i<list.size(); i++) 
		{
		System.out.print(list.get(i) + ", " );
		}
		return print;
	}
}