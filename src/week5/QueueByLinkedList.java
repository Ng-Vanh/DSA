package week5;

import edu.princeton.cs.algs4.In;

public class QueueByLinkedList implements IStackQueue{
    private class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    Node head;
    Node tail;
    QueueByLinkedList(){
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean push(int value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        int res = head.value;

        if(head == tail){
            head = tail = null;
        }
        else{
            head = head.next;
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void print() {
        if(isEmpty()){
            System.out.print("Queue is Empty!!!");
            return;
        }else{
            Node tmp = head;
            while (tmp !=null){
                System.out.print(tmp.value + " ");
                tmp = tmp.next;
            }
        }
    }
}
