package week3;

public class binarySearch {
    public static int binarySearch(int[] a, int number){
        int l = 0;
        int r = a.length - 1;
        while(l<=r){
            int mid = (l + r)/2;
            if(a[mid] == number){
                return mid;
            }else if(a[mid] > number){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2,5,7,9,12,34,45,49};
        int res = binarySearch(arr, 12);
        System.out.println(res);
    }
}
