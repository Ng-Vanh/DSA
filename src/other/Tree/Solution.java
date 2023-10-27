package other.Tree;

public class Solution {
    public static void main(String[] args) {
        BST b = new BST();
        b.insert(5);
        b.insert(3);
        b.insert(6);
        b.insert(2);
        b.insert(4);
        b.insert(7);
        b.preorderTraversal(b.myRoot);
        System.out.println();
        b.inorderTraversal(b.myRoot);
        System.out.println();
        b.postorderTraversal(b.myRoot);
    }
}
