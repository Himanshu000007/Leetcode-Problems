class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        double sum = 0;
        for(int i = 0;i<k;i++){
            sum += nums[i];
            avg = sum/k;
        }
        // leet added
        double max = avg;
        for(int i=k;i<nums.length;i++){
            sum -= nums[i-k];
            sum += nums[i];
            avg = sum/k;
            max = Math.max(max,avg);
        }
        return max;
    }
}