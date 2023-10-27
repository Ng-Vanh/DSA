package Bonus.week8;

import java.util.List;

public class JesseAndCookies {
    private class MinHeap{
        private static final int MAX_SIZE = 1000000;
        private int[] heap;
        private int size;

        public MinHeap() {
            heap = new int[MAX_SIZE + 1];
            size = 0;
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
    }
    public int cookies(int k, List<Integer> A) {
        MinHeap heap = new MinHeap();
        int res = -1;
        int cnt = 0;
        for (int i = 0; i < A.size(); i++) {
            heap.insert(A.get(i));
        }

        while(heap.peek() < k && heap.size > 1){
            int smallest = heap.poll();
            int small2est = heap.poll();
            int tmp = smallest + 2 * small2est;
            heap.insert(tmp);
            cnt++;
        }
        if(heap.peek() >=k){
            return cnt;
        }return -1;
    }
}
