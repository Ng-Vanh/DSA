package week4;

public class MyLinkedList {
    private Node head;

    public MyLinkedList() {
        head = null;
    }

    public void addTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
    public void delete(int data) {
        head = deleteRecursive(head, data);
    }

    private Node deleteRecursive(Node current, int data) {
        if (current == null) {
            return null;
        }

        if (current.value == data) {
            return current.next;
        }

        current.next = deleteRecursive(current.next, data);
        return current;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addFirst(100);
        linkedList.addTail(1);
        linkedList.addTail(2);
        linkedList.addTail(3);
        linkedList.addFirst(100);
        linkedList.delete(100);

        linkedList.display();
    }


}
