package week3.BTVN;

public class BinarySearch {
    public int firstBinarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int res = -1;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] == value){
                res = mid;
                right = mid -1;
            }else if( arr[mid] > value){
                right = mid - 1;

            }else{
                left = mid + 1;
            }
        }
        return res;
    }
}
