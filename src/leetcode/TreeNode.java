package leetcode;

import sun.reflect.generics.tree.Tree;

public class TreeNode <T>{
    TreeNode left;
    TreeNode right;
    T value;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode( T value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
