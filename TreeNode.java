class TreeNode {
    Object item;
    TreeNode leftChild;
    TreeNode rightChild;
    public TreeNode(Object value) {
        item = value;
        leftChild = null;
        rightChild = null;
    }
    public TreeNode(Object value, TreeNode left, TreeNode right) {
        item = value;
        leftChild = left;
        rightChild = right;
    }
}