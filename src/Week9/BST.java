package Week9;


import java.util.LinkedList;
import java.util.Queue;

public class BST {
    TreeNode myRoot;

    public BST() {
        myRoot = null;
    }

    ;

    /**
     * Thêm 1 node vào cây:
     * TH1: root = null => root = newNode
     * TH2: root != null : duyệt cây nếu newNode > curNode duyệt sang phải còn
     * không duyệt sang trái. Nếu gặp null thì gán bằng newNode.
     */
    public void insert(int value) {
        myRoot = insertRec(myRoot, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }


    /**
     * Xóa 1 node khỏi cây:
     * TH1: Node cần xóa là lá: tìm cha của node và trỏ nó về null
     * TH2: Node cần xóa có 1 con: trỏ vào con Node cần xóa
     * Th3: Node cần xóa có 2 con: Thay node bị xóa bằng node trái cùng của cây con bên phải
     * hoặc thay noed bị xóa bằng node phải cùng của cây con bên trái.
     */
    public void delete(int value) {
        myRoot = deleteRec(myRoot, value);
    }

    private TreeNode deleteRec(TreeNode root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }
    //

    private int minValue(TreeNode node) {
        int minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }
    //https://www.hackerrank.com/challenges/tree-preorder-traversal/problem

    public void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    //https://www.hackerrank.com/challenges/tree-inorder-traversal/problem

    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value + " ");
            inorderTraversal(root.right);
        }
    }

    public void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    //https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
    public void levelOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
