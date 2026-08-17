class Solution {
    public int majorityElement(int[] nums) {
        int a = nums.length/2;
        int count = 1;
        int netaji = nums[0];

        for(int i = 1;i<nums.length;i++){
            if(count == 0){
                netaji = nums[i];
            }
            if(nums[i] == netaji){
                count++;
            }else{
                count--;
            }
        }
        return netaji;
        
    }
}