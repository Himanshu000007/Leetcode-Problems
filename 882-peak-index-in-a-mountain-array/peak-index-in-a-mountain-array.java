class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length <= 1)return 0;
        if(arr.length <= 2)return 0;
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if((arr[mid] > arr[mid+1]) && (arr[mid] > arr[mid-1])){
                return mid;
            }else if(arr[mid] < arr[mid+1]){
                low = mid;
            }else{
                high = mid;
            }
        }
        return 1;
    }
}