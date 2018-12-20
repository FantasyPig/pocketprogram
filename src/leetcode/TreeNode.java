package leetcode;

import sun.reflect.generics.tree.Tree;

public class TreeNode <T>{
    public TreeNode left;
    public TreeNode right;
    public T value;

    public TreeNode(T value) {
        this.value = value;
    }
    public TreeNode() {

    }


    public TreeNode( T value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
