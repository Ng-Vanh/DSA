package Bonus;

import java.util.Scanner;

public class VeBo2 {
    public static class MinHeap {
        private static final int MAX_SIZE = 100005;
        private int[] heap;
        private int size;

        public MinHeap() {
            heap = new int[MAX_SIZE + 1];
            size = 0;
        }
        public void printHeap(){
            for (int i = 1; i <= size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
        public boolean isEmpty(){
            return size == 0;
        }

        public void insert(int value) {
            if(isEmpty()){
                heap[1] = value;
                size++;
                return;
            }else{
                size++;
                heap[size] = value;
                int child = size;
                int parent = child / 2;
                while(parent >= 1 && heap[parent] > heap[child]){
                    int tmp = heap[parent];
                    heap[parent] = heap[child];
                    heap[child] = tmp;
                    child = parent;
                    parent = parent / 2;
                }
            }

        }

        public int peek() {
            return heap[1];
        }

        public int poll(){
            if(isEmpty()){
                return -1;
            }
            int min = heap[1];
            heap[1] = heap[size];
            size--;
            int parent = 1;
            while (true) {
                int left = 2 * parent;
                int right = 2 * parent + 1;
                int smallest = parent;

                if (left <= size && heap[left] < heap[smallest]) {
                    smallest = left;
                }
                if (right <= size && heap[right] < heap[smallest]) {
                    smallest = right;
                }

                if (smallest == parent) {
                    break;
                }

                int tmp = heap[parent];
                heap[parent] = heap[smallest];
                heap[smallest] = tmp;

                parent = smallest;
            }
            return min;
        }

        public int getSize() {
            return size;
        }
    }

    public static void main(String[] args){
        MinHeap minHeap = new MinHeap();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (minHeap.getSize() < k) {
                minHeap.insert(tmp);
                sum += tmp;
                System.out.print(sum + " ");

            } else {
                if (tmp <= minHeap.peek()) {
                    System.out.print(sum + " ");
                } else {
                    sum -= minHeap.poll();
                    minHeap.insert(tmp);
                    sum += tmp;
                    System.out.print(sum + " ");
                }


            }
        }
    }
}
