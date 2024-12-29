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
    }
}
