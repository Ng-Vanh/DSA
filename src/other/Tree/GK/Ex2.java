package other.Tree.GK;

import edu.princeton.cs.algs4.Queue;

import java.util.LinkedList;
import java.util.Scanner;

public class Ex2 {
    private static class ArrayLinkedList{
        private int[] array;
        private int size;

        public ArrayLinkedList() {
            array = new int[1000000];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Invalid index");
            }
            return array[index];
        }

        public void insertAt(int index, int item) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Invalid index");
            }

            if (size == array.length) {
                // Nếu mảng đã đầy, hãy mở rộng nó
                int[] newArray = new int[array.length * 2];
                System.arraycopy(array, 0, newArray, 0, size);
                array = newArray;
            }

            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = item;
            size++;
        }

        public int removeAt(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Invalid index");
            }

            int removedItem = array[index];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;

            return removedItem;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayLinkedList[] h = new ArrayLinkedList[3];
        for (int i = 0; i < 3; i++){
            h[i] = new ArrayLinkedList();
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            h[0].insertAt(i,i+1);
        }
        int q = sc.nextInt();
        while(q-->0){
            int cmd = sc.nextInt();
            if(cmd == 1){
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                if(!h[u].isEmpty()){
                    int x = h[u].removeAt(0);
                    h[v].insertAt(0,x);
                }
            }else if(cmd == 2){
                
            }
        }


    }

}
