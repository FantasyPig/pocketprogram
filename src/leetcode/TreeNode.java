package leetcode;

public class TreeNode<T> {

    T data;
    TreeNode left;
    TreeNode right;

    TreeNode(T data){
        this.data = data;
    }

    TreeNode(T data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    TreeNode(){

    }
}
