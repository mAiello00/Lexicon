package libraryLexicon;
import java.io.File;

/**
 * Lexicon is the main component in this assignment.
 * It initializes a hash table, reads all input files and adds all words to the index (hash table).
 * A series of words are then searched and the results are printed in the console and saved in a file.
 * 
 *
 */
public class Lexicon {
	/**
	 * Initializes a hash table to serve as an index.
	 * Reads all input files and adds all words to the index.
	 * Performs a query for a series of words.
	 * @param theTestFile It is the file name of the file containing the words to be searched
	 */
	
	public void processLexicon(String theTestFile) {
		HashTable wordHashTable = new HashTable();

		InputFileReader reader = new InputFileReader();
		reader.readAllFiles(wordHashTable);

		Searcher searcher = new Searcher(wordHashTable, theTestFile);
		searcher.findAllWords();
	}

	
	public static void main(String[] args) {
		/**
		 * @param args The only argument is the file name of the file containing the words to be searched
		 */
		Lexicon lexicon = new Lexicon();
		String theTestFile = args[0];
		
	    File theOutputFile = new File("output_"+args[0]);
		if (theOutputFile.exists()){
		     theOutputFile.delete();
		 }  
		lexicon.processLexicon(theTestFile);
	}

}
