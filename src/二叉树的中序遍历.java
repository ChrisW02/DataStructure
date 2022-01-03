import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// @solution-sync:begin
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) { // Recursion
        List<Integer> nlist = new ArrayList<>();
        nlist = traversal(root, nlist);
        return nlist;
    }

    public List<Integer> traversal(TreeNode n, List<Integer> list) {
        if (n != null) {
            traversal(n.left, list);
            list.add(n.val);
            traversal(n.right, list);
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) { // Iteration
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.addFirst(root);
                root = root.left;
            }
            root = deque.removeFirst();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }
}