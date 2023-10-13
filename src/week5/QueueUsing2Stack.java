package week5;

import java.util.Scanner;

public class QueueUsing2Stack {
    //link: https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    QueueUsing2Stack() {
        head = null;
        tail = null;
    }

    // them 1 phan tu vao hang doi:
    public void Enqueue(int value) {
        Node newNode = new Node(value);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int Dequeue() {
        int res = 0;
        if (head == null && tail == null) {
            return Integer.MIN_VALUE;
        }
        res = head.value;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        return res;
    }

    public void printFirst() {
        int tmp = head.value;
        System.out.println(tmp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsing2Stack st = new QueueUsing2Stack();
        int queries = sc.nextInt();
        while (queries-- > 0) {
            int fNum = sc.nextInt();
            if (fNum == 1) {
                int scNum = sc.nextInt();
                st.Enqueue(scNum);
            } else if (fNum == 2) {
                st.Dequeue();
            } else if (fNum == 3) {
                st.printFirst();
            }
        }
    }
}
