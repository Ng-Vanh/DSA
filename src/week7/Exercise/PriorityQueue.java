package week7.Exercise;

public class PriorityQueue {
    private int max_size;
    private int[] queue;
    private int size;
    public PriorityQueue(int[] queue, int max_size) {
        this.max_size = max_size;
        queue = new int[max_size];
    }
    public void insert(int n){
        if (size == max_size){
            throw new RuntimeException("Queue is full");
        }
        queue[size] = n;
        size++;
    }
    public int deleteMin(){
        return 0;
    }
}
