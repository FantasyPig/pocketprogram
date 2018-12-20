package tree;

public class BinaryTreeNode {

    BinaryTreeNode left;
    BinaryTreeNode right;
    int value;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
