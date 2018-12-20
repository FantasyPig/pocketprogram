package tree;

import java.util.LinkedList;

//中序、层次、深度遍历
public class ForEach {

    //中序遍历迭代
    public static void forEachMiddle(BinaryTreeNode root) {
        if(root == null) {
            return;
        }
        forEachMiddle(root.left);
        System.out.print(root.value + " ");
        forEachMiddle(root.right);
    }

    //中序遍历循环
    public static void forEachMiddle2(BinaryTreeNode root) {
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                BinaryTreeNode tmpNode = stack.pop();
                System.out.print(tmpNode.value + " ");
                root = tmpNode.right;

            }
        }
    }

    //层次遍历
    public static void forEachRow(BinaryTreeNode root) {
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryTreeNode tmpNode = queue.removeFirst();
            System.out.print(tmpNode.value + " ");
            if(tmpNode.left != null) {
                queue.add(tmpNode.left);
            }
            if(tmpNode.right != null) {
                queue.add(tmpNode.right);
            }
        }
    }

    //深度遍历
    public static void forEachCol(BinaryTreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.value + " ");
        if(root.left != null) {
            forEachCol(root.left);
        }
        if(root.right != null) {
            forEachCol(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(16);
        BinaryTreeNode node2 = new BinaryTreeNode(12);
        BinaryTreeNode node3 = new BinaryTreeNode(8);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(node2, node1, 14);
        BinaryTreeNode node6 = new BinaryTreeNode(node4, node3, 6);
        BinaryTreeNode node7 = new BinaryTreeNode(node6, node5, 10);
        forEachMiddle(node7);
        System.out.println();
        forEachRow(node7);
        System.out.println();
        forEachCol(node7);
    }
}
