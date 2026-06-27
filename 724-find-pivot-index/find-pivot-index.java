class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
    
        int total = 0;
        for(int i = 0;i<n;i++){
            total += nums[i];
        }
        int left = 0;
        for(int i=0;i<n;i++){
            if(left == total - nums[i] - left){
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}