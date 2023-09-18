class BinaryTree{
    BTNode root; // The binary tree root
    int count; // Number of elements currently in the node
    BinaryTree(){}
    BinaryTree(String str){
        root = new BTNode(str);
    }
    /**
     * @return Number of elements in the binary
     * search tree.
     */
    public int size(){
        // Change the body of this method
        if (root == null) return 0;
        else return count;
    }
    /**
     * Insert the string in the parameter into
     * the Binary Search Tree.
     * @param str
     * @return true if insertion is successful.
     */
    public boolean insertBST(String str){
        BTNode parent = new BTNode(str); // create a new node to contain the string to be inserted
        if(root == null){ // if your root is null then root receives the data from the new node
            root = parent;
            count++; // increment size
            return true;
        }
        BTNode currentNode = root; // if there is a root then insert a new node
        while(true){
            if(currentNode.data.toString().compareTo(str)<0) { // if data is greater, insert on right
                if(currentNode.right==null) {
                    currentNode.right = parent;
                    count++;
                    return true;
                }
                currentNode = currentNode.right;
            }
            else if(currentNode.data.toString().compareTo(str)>0) { // if data is lesser, insert on left
                if(currentNode.left==null) {
                    currentNode.left = parent;
                    count++;
                    return true;
                }
                currentNode = currentNode.left;
            }
            else return false;
        }
    }
    /**
     * Return an array of strings containing the
     * string content elements of the tree.
     * Order of the strings in the array does not matter.
     * @return a String array
     */
    public String[] getAsArray(){
        String[] planetArray = new String[count]; // create an array that takes in the data
        int index  = 0; // start from index zero (root)
        return iterateArray(root,planetArray,index); // call method to helper method
    }
    private String[] iterateArray(BTNode root, String[] planetArray, int i) { // helper method to read and iterate through the string array
        if(root==null) return null; // if root is null return null
        while(planetArray[i] != null) i++; // while there is an element, iterate through the array
        planetArray[i] = root.data.toString(); // begin with the root
        iterateArray(root.left, planetArray, i+1); // iterate through elements on left
        iterateArray(root.right, planetArray, i+1); // iterate through elements on right
        return planetArray; // return array
    }
    /**
     * Print the binary tree in the format
     * shown in the output.
     */
    public void printBT(){
        printHelper(root, 0); // method call to helper method
    }
    private void printHelper(BTNode root, int n) { // create a helper to process data
        for (int i = 0; i < n; i++) System.out.print(" "); // iterate throughout the tree
        if (root == null) { // if root is null print out '-'
            System.out.println("-");
            return; // return nothing
        } // else print
        System.out.println("---" + root.data); // print data
        printHelper(root.left, n + 1);
        printHelper(root.right, n + 1);
    }
    /**
     * Search the binary tree for the given string.
     * @param str
     * @return true if str is in the binary search tree.
     */

    public boolean searchBT(String str) {
        // Change the body of this method
        BTNode currentNode = root;
        while (currentNode != null) {
            if (str.compareTo(currentNode.data.toString()) < 0) {
                currentNode = currentNode.left;
            } else if (str.compareTo(currentNode.data.toString()) > 0) {
                currentNode = currentNode.right;
            } else
                return true;
        }
        return false;
    }
    /**
     * Print the elements of the binary
     * search tree in ascending order.
     */
    public void printAscending(){ // method call to helper method
        ascendingHelper(root);
    }
    private void ascendingHelper(BTNode root) { // print using in-order traversal
        if(root == null) return; // if null return null
        ascendingHelper(root.left); // left
        System.out.println(root.data); // root
        ascendingHelper(root.right); // right
    }
    /**
     * Print the elements of the binary
     * search tree in descending order.
     */
    public void printDescending(){ // method call to helper method
        descendingHelper(root);
    }
    private void descendingHelper(BTNode root) { // print using "reverse" in-order traversal
        if(root == null) return; // if null return null
        descendingHelper(root.right); // right
        System.out.println(root.data); // root
        descendingHelper(root.left); // left
    }
}