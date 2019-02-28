package leetcode;

public class Leetcode129 {
      public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
      }
    public boolean isValidBST(TreeNode root) {
        Boolean[] result = new Boolean[1];
        result[0] = true;
        check(root, null, null, result);
        return result[0];
    }

    private void check(TreeNode node, Integer max, Integer min, Boolean[] result) {
          if (node == null) {
              return;
          }
          if ((max != null && node.val >= max) || (min != null && node.val <= min)) {
            result[0] = false;
          }
          check(node.left, node.val, min, result);
          check(node.right, max, node.val, result);
    }

}
