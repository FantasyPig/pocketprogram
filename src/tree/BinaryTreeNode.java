package tree;

public class BinaryTreeNode {

    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public int value;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
