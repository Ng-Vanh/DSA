package week5;

import java.util.ArrayList;
import java.util.List;

public class StackByLinkedList implements IStackQueue{
    private class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    Node topNode;
    StackByLinkedList(){
        topNode = null;
    }

    @Override
    public boolean push(int value) {
        Node newNode = new Node(value);
        if(topNode == null){
            topNode = newNode;
        }else{
            newNode.next = topNode;
            topNode = newNode;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        if(isEmpty()){
           return Integer.MIN_VALUE;
        }
        int res = topNode.value;
        topNode = topNode.next;
        return res;
    }

    @Override
    public boolean isEmpty() {
        if(topNode == null){
            return  true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void print(){
        if(isEmpty()){
            System.out.print("Stack is Empty!!!");
            return;
        }
        Node tmp = topNode;
        List<Integer> li = new ArrayList<Integer>();
        while (tmp !=null){
            li.add(tmp.value);
            tmp = tmp.next;
        }
        for (int i = li.size() -1; i >=0 ; i--) {
            System.out.print(li.get(i) + " ");
        }

        System.out.println();
    }
}
