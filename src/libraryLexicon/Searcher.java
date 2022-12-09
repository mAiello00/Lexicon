package libraryLexicon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Searcher {
	private HashTable table; //Reference to the table of binary search trees that implements the lexicon data structure
	private String inputFile; //Name of the input file storing all words that will be searched for in the lexicon data structure
	
	public Searcher(HashTable hTable, String inFile){
		table = hTable;
		inputFile = inFile;
	}
	
	/** 
	 * Reads the input file for each word 'w' in it and invokes the below findWord() method
	 * to look for the word in the lexicon and print information about where the word appears
	 * 
	 */
	public void findAllWords(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			String[] words = line.split(" ");
			
			for(String w : words) {
				findWord(w);
			}
			
			reader.close();
		} catch(IOException e) {
			System.out.println(e);
		}
			
	}
	
	public void findWord(String searchWord){
		int wordHashValue = table.computeIndex(searchWord);//Get the hash value for the word
		BinSearchTree[] hTable = table.getTable();//Get the hashTable as a table of Binary Search Trees
		BinSearchTree currentTree = hTable[wordHashValue];//Get Binary Search Tree from the table we expect the word to be in
		BinSearchTreeNode foundNode = currentTree.getWord(searchWord);
		
		if(foundNode == null)
			CustomPrinter.wordNotFound(searchWord, inputFile);
		else {
			CustomPrinter.wordFound(searchWord, inputFile);
			LinkedList Lp = foundNode.getFiles();//Get the linked list associated with the found node
			
			//Get the first element of the list associated with the node
			FileNode currentNode = Lp.getHead();
			while(currentNode != null) {
				ArrayList<Integer> lq = currentNode.getPositions();
				CustomPrinter.printPositionsPerFileFound(currentNode.getFilename(), lq, inputFile);
				currentNode = currentNode.getNext();
			}
		}
	}
}
