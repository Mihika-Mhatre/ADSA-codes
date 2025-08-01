import java.util.Scanner;

// Node structure for BST
class Node {
    int data;
    Node left, right;

    // Node constructor
    Node(int value) {
        this.data = value;
        left = right = null;
    }
}

public class BSTDemo {
    // Insert a new value in the BST
    Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // Inorder Traversal (Left, Root, Right)
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder Traversal (Root, Left, Right)
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder Traversal (Left, Right, Root)
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BSTDemo bst = new BSTDemo();
        Node root = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the BST:");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = bst.insert(root, value);
        }

        System.out.print("Inorder Traversal: ");
        bst.inorder(root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        bst.preorder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        bst.postorder(root);
        System.out.println();

        sc.close();
    }
}
