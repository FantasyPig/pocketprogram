package pointToOffer;

import leetcode.TreeNode;
import tree.BinaryTreeNode;
import tree.ForEach;

import java.util.Arrays;

/**
 * 重建二叉树
 */
public class Question7 {

    TreeNode<Integer> treeNode;

    public BinaryTreeNode solution(int[] preorder, int[] infixorder) {

        if(preorder.length == 0 || infixorder.length == 0) {
            return new BinaryTreeNode();
        }
        return cur(preorder, infixorder);
    }

    public BinaryTreeNode cur(int[] preorder, int[] infixorder) {
        int len = preorder.length;
        if(len <= 0) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(preorder[0]);
        int infixIndex = findIndex(root.value, infixorder);
        root.left = cur(Arrays.copyOfRange(preorder, 1, infixIndex + 1), Arrays.copyOfRange(infixorder, 0, infixIndex));
        root.right = cur(Arrays.copyOfRange(preorder, infixIndex + 1, len), Arrays.copyOfRange(infixorder, infixIndex + 1, len));
        return root;
    }

    private int findIndex(int val, int[] list) {
        for(int i =0; i < list.length; ++i) {
            if(list[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] inf = {4,7,2,1,5,3,8,6};
        Question7 q = new Question7();
        BinaryTreeNode root = q.solution(pre, inf);
        ForEach.forEachRow(root);
    }
}
