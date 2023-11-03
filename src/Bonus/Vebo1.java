package Bonus;

import java.io.*;
import java.util.*;

public class Vebo1 {

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
    public static class MaxHeap {
        private static final int MAX_SIZE = 100005;
        private int[] heap;
        private int size;
        public MaxHeap() {
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
                while(parent >= 1 && heap[parent] < heap[child]){
                    int tmp = heap[parent];
                    heap[parent] = heap[child];
                    heap[child] = tmp;
                    child = parent;
                    parent = parent / 2;
                }
            }
        }

        public int getSize() {
            return size;
        }

        public int peek() {
            return heap[1];
        }
        public int poll(){
            if(isEmpty()){
                return -1;
            }
            int max = heap[1];
            heap[1] = heap[size];
            size--;
            int parent = 1;
            while (true) {
                int left = 2 * parent;
                int right = 2 * parent + 1;
                int largest = parent;

                if (left <= size && heap[left] > heap[largest]) {
                    largest = left;
                }
                if (right <= size && heap[right] > heap[largest]) {
                    largest = right;
                }

                if (largest == parent) {
                    break;
                }

                int tmp = heap[parent];
                heap[parent] = heap[largest];
                heap[largest] = tmp;

                parent = largest;
            }
            return max;
        }}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        MaxHeap maxHeap = new MaxHeap();
        MinHeap minHeap = new MinHeap();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int query = sc.nextInt();
        for(int i = 0; i < size; i++) {
            int n = sc.nextInt();
            if (maxHeap.isEmpty() || n <= maxHeap.peek()) {
                maxHeap.insert(n);
            } else {
                minHeap.insert(n);
            }
            if (maxHeap.getSize() > minHeap.getSize() + 1){
                minHeap.insert(maxHeap.poll());
            }else if (maxHeap.getSize() < minHeap.getSize()){
                maxHeap.insert(minHeap.poll());
            }
        }
        while(query-->0){
            int op = sc.nextInt();
            if(op == 1){
                int add = sc.nextInt();
                if (maxHeap.isEmpty() || add <= maxHeap.peek()) {
                    maxHeap.insert(add);
                } else {
                    minHeap.insert(add);
                }
                if (maxHeap.getSize() > minHeap.getSize() + 1){
                    minHeap.insert(maxHeap.poll());
                }else if (maxHeap.getSize() < minHeap.getSize()){
                    maxHeap.insert(minHeap.poll());
                }
            }
            else if(op == 2){
                if(!maxHeap.isEmpty()){
                    maxHeap.poll();
                    if (maxHeap.getSize() > minHeap.getSize() + 1){
                        minHeap.insert(maxHeap.poll());
                    }else if (maxHeap.getSize() < minHeap.getSize()){
                        maxHeap.insert(minHeap.poll());
                    }
                }
            } else if (op == 3) {
                if(!maxHeap.isEmpty()){
                    System.out.println(maxHeap.peek());
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}
