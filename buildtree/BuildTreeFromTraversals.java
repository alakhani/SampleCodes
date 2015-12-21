package buildtree;


/*
 * Build a binary tree from inorder and preorder traversals
 * Author : Aamin Lakhani
 */
public class BuildTreeFromTraversals {

	
	public static Node build(String[] inOrder, String[] preOrder, int inStart, int inEnd, int preStart) {
		
		if (inStart > inOrder.length - 1 || preStart > preOrder.length ||  inEnd < 0) {

		    return null;

		}
		String rootValue = preOrder[preStart];
		Node root = new Node(rootValue);
		
		if (inStart >= inEnd) {
			return root;
		}
		
		int index = -1;
		//else find the index in the inoder traversal
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i].equals(rootValue)) {
				index = i ;
				break;
			}
		}
		
		root.setLeft(build(inOrder, preOrder, inStart, index-1, preStart+1));
		root.setRight(build(inOrder, preOrder, index+1, inEnd, preStart+(index - inStart)+1));
		
		return root;
	}
	
	
	public static void main (String args[]) {
		
		String[] inOrder = {"D", "B", "E", "A", "F", "C"};
		String[] preOrder = {"A", "B", "D", "E", "C", "F"};
		build(inOrder, preOrder, 0, inOrder.length,0);
	}
}
