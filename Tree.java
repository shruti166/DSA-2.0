import java.util.ArrayList;
import java.util.Arrays;

public class Tree {
    int val;
    Tree left;
    Tree right;

    // Constructor for Tree nodes
    public Tree(int data) {
        this.val = data;
        this.left = null;
        this.right = null;
    }
}

class CreateTree {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        // Create the root node
        Tree root = new Tree(2);

        // Add child nodes
        root.left = new Tree(3);
        root.right = new Tree(4);

        // Print values to verify
        System.out.println("Root value: " + root.val);
        System.out.println("Left child value: " + root.left.val);
        System.out.println("Right child value: " + root.right.val);


        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        Tree rootRecursive = createTreeRecursive(res, 0);
        ArrayList<Integer> inorderResult = inorderTraversal(rootRecursive);
        System.out.println(inorderResult);

        System.out.println("Root value from createTreeRecursive: " + rootRecursive.val);

    }

    //Recursively create tree

    public static Tree createTreeRecursive(ArrayList<Integer> arr, int idx) {

        if(idx >= arr.size()) {
            return null;
        }

        Tree root = new Tree(arr.get(idx));
        root.left = createTreeRecursive(arr, 2*idx+1);
        root.right = createTreeRecursive(arr, 2*idx+2);


        return root;

    }

    public static ArrayList<Integer> inorderTraversal(Tree root) {
        if(root == null) {
            return null;
        }

        inorderTraversal(root.left);
        arr.add(root.val);
        inorderTraversal(root.right);

        return arr;
    }




}


