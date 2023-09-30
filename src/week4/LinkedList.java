package week4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private Node head;

    public LinkedList(Node head) {
        this.head = head;
    }
    public LinkedList(){
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public static void printLinkedList(Node head){
//        Node run = head;
        if(head == null){
            System.out.println("List is Empty");
        }else{
            Node cur = head;
            while (cur!=null){
                System.out.print(cur.value+" ");
                cur = cur.next;
            }
        }
        System.out.println();

    }
    public static int getLength(Node head){
        int cnt = 0;
        if (head == null){
            return 0;
        }
        while (head!=null){
            cnt++;
            head = head.next;
        }
        return cnt;
    }
    public static Node addFirst(Node head, int val){
        Node newNode = new Node(val);
        if(head!=null){
            newNode.next = head;
        }

        return newNode;
    }
    public static Node addTail(Node head, int val){
        Node newNode = new Node(val);
        if(head == null){
            return newNode;
        }else{
            Node cur = head;
            while (cur.next!=null){
                cur = cur.next;
            }
            cur.next = newNode;
            return head;
        }
    }
    public static Node addMid(Node head, int val, int pos){
        Node newNode = new Node(val);
        if(pos==0){
            newNode.next = head;
            head = newNode;
            return newNode;
        }else{
            Node cur = head;
            int cnt = 0;
            while (cur != null){
                cnt++;
                if(cnt==pos){
                    newNode.next = cur.next;
                    cur.next = newNode;
                    break;
                }
                cur = cur.next;
            }
        }

        return head;
    }
    public static Node deleteHead(Node head){
       if(head!=null){
           return head.next;
       }else{
           return head;
       }
    }
    public static Node deleteTail(Node head){
        if(head == null){
            return null;
        }else{
            Node prev = null;
            Node last = head;
            while (last.next != null){
                prev = last;
                last = last.next;
            }
            if(prev == null){
                return null;
            }else{
                prev.next = null;
            }
            return head;
        }
    }
    public static Node deleteMid(Node head, int pos){
        if(head == null || pos < 0){
            return null;
        }else if(pos == 0)
        {
            return deleteHead(head);
        }
        Node cur = head;
        int cnt = 0;
        while (cur!=null && cnt<pos-1){
            cur = cur.next;
            cnt++;
        }
        if(cur == null || cur.next ==null){
            return head;
        }
        cur.next = cur.next.next;
        return head;
    }
    public static void printReverse(Node head){
        if(head == null){
            System.out.println("Linked-list is NULL !!");
        }else{
            Stack<Integer> st = new Stack<Integer>();
            Node tmp = head;
            while (tmp!=null){
                st.push(tmp.value);
                tmp = tmp.next;
            }
            while (!st.isEmpty()){
                System.out.print(st.pop()+" ");
            }
        }
    }

    public static Node reverseLinked(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node cur = head;
        while (cur != null) {
            //Lấy Node next là vị trí tiếp theo
            Node next = cur.next;
            //đảo ngược liên kết cur: Ban đầu cur trỏ đến nút sau, nhưng
            //ở đây đảo về trỏ đến prev
            cur.next = prev;
            //dịch prev và cur đến nút kế tiếp.
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public static Node reverseDquy(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node res = reverseDquy(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
    public static boolean compareList(Node head1, Node head2){
        List<Integer> arr1 = new ArrayList<Integer>();
        List<Integer> arr2 = new ArrayList<Integer>();

        Node cur1 = head1;
        Node cur2 = head2;

        while (cur1!=null){
            arr1.add(cur1.value);
            cur1 = cur1.next;
        }
        while (cur2!=null){
            arr2.add(cur2.value);
            cur2 = cur2.next;
        }
        if(arr1.size()!=arr2.size())
        {
            return false;
        }else {
            for (int i = 0; i < arr1.size(); i++) {
                if (arr1.get(i)!=arr2.get(i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static int getNode(Node head, int posFromTail){
        if (head == null){
            return -1;
        }
        Node cur = head;
        int total = 0;
        while (cur!=null){
            total++;
            cur = cur.next;
        }
        int realPos = total - posFromTail - 1;
        cur = head;
        while (realPos--!=0){
            cur = cur.next;
        }

        return cur.value;
    }
    public static Node mergeList(Node head1, Node head2){
        Node res =new Node(-1);
        Node cur = res;
        while (head1!=null && head2!=null){
            if(head1.value<head2.value){
                cur.next = head1;
                head1 = head1.next;
            }else{
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if(head1 == null){
            cur.next = head2;
        }else if(head2 == null){
            cur.next = head1;
        }
        return res.next;
    }
    public static Node removeDuplicates(Node head){
        Node cur = head;
        while (cur!=null && cur.next!=null){
            if(cur.value == cur.next.value){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
    public static boolean hasCycle(Node head){
        Node trans1Node = head;
        Node trans2Node = head;

        while (trans2Node!=null && trans2Node.next !=null){
            trans1Node = trans1Node.next;
            trans2Node = trans2Node.next.next;

            if(trans1Node == trans2Node){
                return true;
            }
        }
        return false;
    }
    public static int findMergeNode(Node head1, Node head2){
        int sz1 = getLength(head1);
        int sz2 = getLength(head2);

        Node cur1 = head1;
        Node cur2 = head2;

        int differentLength = Math.abs(sz1-sz2);
        
        if(sz1 >sz2){
            for (int i = 0; i <differentLength ; i++) {
                cur1 = cur1.next;
            }
        } else if (sz1 < sz2) {
            for (int i = 0; i <differentLength ; i++) {
                cur2 = cur2.next;
            }
        }

        while (cur1!=null && cur2 !=null){
            if(cur1 == cur2){
                return cur1.value;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
