import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            // Set comparison value for this level
            int prevValue = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();

                // Even level: values should be odd and strictly increasing
                if (level % 2 == 0) {
                    if (top.val % 2 == 0 || top.val <= prevValue) return false;
                }
                // Odd level: values should be even and strictly decreasing
                else {
                    if (top.val % 2 == 1 || top.val >= prevValue) return false;
                }

                prevValue = top.val;  // Update the last seen value for comparison

                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);
            }

            level++; // Move to the next level
        }

        return true;
    }
}
