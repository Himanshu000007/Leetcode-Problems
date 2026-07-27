class Solution {
    public int maxProduct(int[] nums) {
        int first = 1;
        int second = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= first){
                second = first;
                first = nums[i];
            }else if(nums[i] > second && nums[i] < first){
                second = nums[i];
            }
        }
        return (first-1) * (second-1);
        
    }
}