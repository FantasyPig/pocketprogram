package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode104 {

    //way 1
    public static int recursion(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Integer.max(recursion(root.left) , recursion(root.right));
    }

    //way 2
    public static int bfs(TreeNode root){
        int height = 1;
        List<TreeNode> row = new LinkedList<>();
        List<TreeNode> tmpRow = new LinkedList<>();
        row.add(root);
        while(!row.isEmpty()){
            for (TreeNode node : row) {
                if(node.left != null)
                    tmpRow.add(node.left);
                if(node.right != null)
                    tmpRow.add(node.right);
            }
            row.clear();
            if(!tmpRow.isEmpty())
                ++height;
            row.addAll(tmpRow);
            tmpRow.clear();
        }
        return height;
    }

    public static void main(String args[]){
        TreeNode<Integer> node1 = new TreeNode<>(15);
        TreeNode<Integer> node2 = new TreeNode<>(7);
        TreeNode<Integer> node3 = new TreeNode<>(20, node1, node2);
        TreeNode<Integer> node4 = new TreeNode<>(9);
        TreeNode<Integer> root = new TreeNode<>(3, node4, node3);
        TreeNode<Integer> node11 = new TreeNode<>(11);
        node4.left = node11;
        System.out.println(LeetCode104.bfs(root));
        System.out.println(LeetCode104.recursion(root));
    }
}
