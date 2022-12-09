package libraryLexicon;

public class BinSearchTree {
	private BinSearchTreeNode root;
	
	/**
	 * Returns the node of the binary search tree storing searchWord, or null if no node stores it.
	 * 
	 **/
	public BinSearchTreeNode getWord(String searchWord){
		return search(root, searchWord);
	}
	
	/**
	 * Compares the word in the current node of the binary tree with the word we are searching for.
	 * If the word in the current node is lexicographically larger than 'searchWord', go to the next left node.
	 * If the word in the current node is lexicographically smaller than 'searchWord', go to the next right node.
	 * If the current node is null, then we are at the end of the tree and did not find the word we needed, so return null.
	 **/
	private BinSearchTreeNode search(BinSearchTreeNode curr, String searchWord){
		
		if(curr == null)
			return null;
		else if(searchWord.compareTo(curr.getWord()) == 0)
			return curr;
		else if(searchWord.compareTo(curr.getWord()) < 0)
			return search(curr.getLeft(), searchWord);
		else
			return search(curr.getRight(), searchWord);
	}
	
	public void insertWord(String theWord, String theFileName, int thePosition){
		if(root == null)
			root = new BinSearchTreeNode(theWord, theFileName, thePosition);
		else if(theWord.compareTo(root.getWord()) < 0) {
			if(root.getLeft() == null) {
				BinSearchTreeNode newNode = new BinSearchTreeNode(theWord, theFileName, thePosition);
				root.setLeft(newNode);
			}
			else
				insert(root.getLeft(), theWord, theFileName, thePosition);
		}
		else if(root.getRight() == null) {
			BinSearchTreeNode newNode = new BinSearchTreeNode(theWord, theFileName, thePosition);
			root.setRight(newNode);
		}
		else
			insert(root.getRight(), theWord, theFileName, thePosition);
	}
	
	/**
	 *Auxiliary method for inserting nodes into the tree.
	 **/
	private void insert(BinSearchTreeNode childNode, String tWord, String fName, int pos) {	
		if(childNode == null)
			childNode = new BinSearchTreeNode(tWord, fName, pos);
		else if(tWord.compareTo(childNode.getWord()) < 0) {
			if(childNode.getLeft() == null) {
				BinSearchTreeNode newNode = new BinSearchTreeNode(tWord, fName, pos);
				childNode.setLeft(newNode);
			}
			else
				insert(childNode.getLeft(), tWord, fName, pos);
		}
		else if(childNode.getRight() == null) {
			BinSearchTreeNode newNode = new BinSearchTreeNode(tWord, fName, pos);
			childNode.setRight(newNode);
		}
		else
			insert(childNode.getRight(), tWord, fName, pos);
	}
}
