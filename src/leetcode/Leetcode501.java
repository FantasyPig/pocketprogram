package leetcode;

import java.util.*;

public class Leetcode501 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
            addMap(map, node.val);
        }
        List<Integer> result = new ArrayList<>();
        ArrayList<Integer> values = (ArrayList<Integer>) map.values();
        int max = Integer.MIN_VALUE;
        for (Integer i: values
             ) {
            if (i > max) {
                max = i;
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        int[] realResult = new int[result.size()];
        for (int i = 0; i < realResult.length; ++i) {
            realResult[i] = result.get(i);
        }
        return realResult;
    }

    private void addMap(Map<Integer, Integer> map, Integer num) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }

}
