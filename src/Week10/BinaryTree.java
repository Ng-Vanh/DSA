package Week10;

import java.util.*;
import java.io.*;


class BinaryTree {
    public static class Node {
        Node left;
        Node right;
        int data;
        int ht;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
        int getHt(){
            return ht;
        }
        void setHt(int ht) {
            this.ht = ht;
        }
    }

    //https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
    public static int height(Node root) {
        if (root == null) {
            return -1;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }

    //https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
    //Cach1:
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }
    }

    //Cach2: Dung Đệ quy
    public static Node insertReq(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            if (data <= root.data) {
                root.left = insertReq(root.left, data);
            } else {
                root.right = insertReq(root.right, data);
            }
            return root;
        }
    }



    //https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
    public Node lca(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        if (node.data == n1 || node.data == n2) {
            return node;
        }

            Node leftLCA = lca(node.left, n1, n2);
        Node rightLCA = lca(node.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return node;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }


    public static void preOrder(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }
    //Insert su dung duyet.


    //https://www.hackerrank.com/challenges/is-binary-search-tree/problem
    public static int arr[] = new int[1000005];
    static int si = 0;
    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        arr[++si] = root.data;
        inorder(root.right);
    }
    public boolean isBST(Node root){
        inorder(root);
        for(int i = 1; i < si; i++){
            if(arr[i] >= arr[i+1]){return false;}
        }
        return true;
    }
    //Cach 2:
    public boolean checkBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node node, int min, int max) {
        // Trường hợp cơ bản: cây rỗng là BST
        if (node == null) {
            return true;
        }

        // Kiểm tra giá trị của nút hiện tại có nằm giữa min và max không
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Kiểm tra các cây con trái và phải với giới hạn giá trị thích hợp
        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }


    //https://www.hackerrank.com/challenges/self-balancing-tree/



    private static void updateHeight(Node node) {
        if (node != null) {
            node.ht = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    private static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    private static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private static int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public static Node insertAVL(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        } else {
            // Duplicate values are not allowed in AVL tree
            return root;
        }

        // Update height of the current node
        updateHeight(root);

        // Get the balance factor of this node to check for unbalance
        int balance = getBalance(root);

        // Perform rotations if needed to balance the tree
        if (balance > 1) {
            if (val < root.left.data) {
                // Left-Left case
                return rightRotate(root);
            } else {
                // Left-Right case
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }
        if (balance < -1) {
            if (val > root.right.data) {
                // Right-Right case
                return leftRotate(root);
            } else {
                // Right-Left case
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }

        // If the tree is still balanced, return the unchanged root
        return root;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}