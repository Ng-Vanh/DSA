package Week13;

import java.util.*;

class AVLNode {
    int vertex, distance;
    int height;
    AVLNode left, right;

    public AVLNode(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
        this.height = 1;
    }
}

class AVLTree {
    AVLNode root;

    public void insert(int vertex, int distance) {
        root = insert(root, vertex, distance);
    }

    private AVLNode insert(AVLNode node, int vertex, int distance) {
        if (node == null) {
            return new AVLNode(vertex, distance);
        }

        if (vertex < node.vertex) {
            node.left = insert(node.left, vertex, distance);
        } else if (vertex > node.vertex) {
            node.right = insert(node.right, vertex, distance);
        } else {
            // Đỉnh đã tồn tại, có thể cập nhật giá trị nếu cần
            node.distance = distance;
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && vertex < node.left.vertex) {
            return rightRotate(node);
        }

        if (balance < -1 && vertex > node.right.vertex) {
            return leftRotate(node);
        }

        if (balance > 1 && vertex > node.left.vertex) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && vertex < node.right.vertex) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
    public int search(int vertex) {
        AVLNode result = search(root, vertex);
        return (result != null) ? result.distance : Integer.MAX_VALUE;
    }

    private AVLNode search(AVLNode node, int vertex) {
        if (node == null || node.vertex == vertex) {
            return node;
        }

        if (vertex < node.vertex) {
            return search(node.left, vertex);
        } else {
            return search(node.right, vertex);
        }
    }

    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    private int height(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public AVLNode extractMin() {
        if (root == null) {
            return null;
        }

        AVLNode minNode = findMin(root);
        root = delete(root, minNode.vertex);
        return minNode;
    }

    private AVLNode findMin(AVLNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private AVLNode delete(AVLNode root, int vertex) {
        if (root == null) {
            return root;
        }

        if (vertex < root.vertex) {
            root.left = delete(root.left, vertex);
        } else if (vertex > root.vertex) {
            root.right = delete(root.right, vertex);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.vertex = minValue(root.right);

            root.right = delete(root.right, root.vertex);
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private int minValue(AVLNode root) {
        int minValue = root.vertex;
        while (root.left != null) {
            minValue = root.left.vertex;
            root = root.left;
        }
        return minValue;
    }
}

public class test {
    static class DGraph {
        private static int V = 0;
        private static List<List<Node>> adj = new ArrayList<>();

        public DGraph(int V) {
            this.V = V;

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            adj.get(u).add(new Node(v, weight));
            adj.get(v).add(new Node(u, weight));
        }

        static class Node {
            private final int vertex;
            private final int distance;

            public Node(int vertex, int distance) {
                this.vertex = vertex;
                this.distance = distance;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int query = scanner.nextInt();
        while (query-- > 0) {
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();
            DGraph dGraph = new DGraph(nodes);
            AVLTree avlTree = new AVLTree();

            for (int i = 0; i < edges; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                int w = scanner.nextInt();
                dGraph.addEdge(u, v, w);
            }
            int startNode = scanner.nextInt() - 1;

            avlTree.insert(startNode, 0);

            while (avlTree.root != null) {
                AVLNode minNode = avlTree.extractMin();
                int u = minNode.vertex;
                int uDistance = minNode.distance;

                for (DGraph.Node neighbor : DGraph.adj.get(u)) {
                    int v = neighbor.vertex;
                    int weight = neighbor.distance;

                    int newDistance = uDistance + weight;

                    // Nếu tìm thấy độ dài mới ngắn hơn
                    if (newDistance < avlTree.search(v)) {
                        avlTree.insert(v, newDistance);
                    }
                }
            }

            // In độ dài ngắn nhất từ đỉnh xuất phát đến các đỉnh còn lại
            for (int i = 0; i < nodes; i++) {
                if (i != startNode) {
                    System.out.print(avlTree.search(i) + " ");
                }
            }
        }
    }
}

