public class BinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // plusOne: Add 1 to all nodes.

    void plusOne(TreeNode root) {
        if (root == null) return;
        root.val++;
        plusOne(root.left);
        plusOne(root.right);
    }

    // min: Find the minimum value.

    int min(TreeNode node) {
        if (node.left == null)
            return node.val;
        return min(node.left);
    }

    // isSameTree: Judge whether two trees are exactly same.

    boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    // isValidBST: Judge whether a tree is BST.

    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }


    void TraverseBST(TreeNode root, int target) {
        if (root.val == target)
            return;
        if (root.val < target)
            TraverseBST(root.right, target);
        if (root.val > target)
            TraverseBST(root.left, target);
    }
}