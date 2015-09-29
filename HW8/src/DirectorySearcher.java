import java.io.File;
import java.util.ArrayList;

/**
 * Find the files in the given directory and subdirectories that end
 * with the specified extension.
 * @author ghelmer
 *
 */
public class DirectorySearcher {
	private String extension;
	private ArrayList<String> foundFiles;
	// Set ENABLE_DEBUGGING = true to show the name of each directory
	// as it is searched.
	public static final boolean ENABLE_DEBUGGING = false;
	
	/**
	 * Build a DirectorySearcher object to find matches with the given extension.
	 * @param path Pathname to check
	 * @param ext Filename extension to match
	 */
	public DirectorySearcher(String ext)
	{
		extension = ext;
		foundFiles = new ArrayList<String>();
	}

	/**
	 * Start the search for files with the matching extension.
	 * Return the ArrayList of found files.
	 * @return ArrayList of names of files found in search
	 */
	public ArrayList<String> findMatchingFiles(String pathname)
	{
		File path = new File(pathname);
		if (!path.exists())
		{
			throw new IllegalArgumentException("No such file or directory: " + pathname);
		}
		search(path);
		return foundFiles;
	}
	
	/**
	 * Recursively add files with matching extension to the list of files.
	 * If the file is a directory, call the search() method to add files from the subdirectory
	 * to the list.
	 * @param searchFile File to check: if a file, check its name; if a directory, check its files
	 */
	private void search(File searchFile)
	{
		if (searchFile.isFile())
		{
			String fileName = searchFile.getName();
			String fileExtension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			if(fileExtension.equals(extension)){
				foundFiles.add(searchFile.getPath());
			}
			// This File is a regular file (not a directory).
			// If this pathname ends with the specified extension,
			// add its pathname to the foundFiles arraylist.
			// Hint: Use searchFile.getPath() to get the pathname
			// for searchFile object as a string.
			
			// Finish recursion.
			return;
		}
		if (ENABLE_DEBUGGING)
		{
			System.out.println("Searching directory " + searchFile.getPath());
		}
		// Get an array of File objects for all the files in this directory.
		File[] files = searchFile.listFiles();

		// Recursively check each file in the files array.
		for (File file : files)
		{
			// Recursively call search() on this file object.
			search(file);
		}
		if (ENABLE_DEBUGGING)
		{
			System.out.println("Finished searching directory " + searchFile.getPath());
		}
	}
}
