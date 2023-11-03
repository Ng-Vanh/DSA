package week8;

public class MaxHeap {
    private static final int MAX_SIZE = 10000;
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
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.insert(1);
        heap.insert(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(4);
        heap.insert(8);
        heap.insert(0);
        heap.printHeap();
        int x = heap.poll();
        heap.printHeap();
    }
}
