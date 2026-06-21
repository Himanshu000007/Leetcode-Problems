class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
         int max = costs[0];

        for (int i = 1; i < costs.length; i++) {
            max = Math.max(max, costs[i]);
        }

        int[] count = new int[max + 1];

        for (int cost : costs) {
            count[cost]++;
        }

        int bars = 0;

        for(int i=1;i<=max;i++){
            while(count[i] > 0 && coins >= i){
                coins -= i;
                bars++;
                count[i]--;
            }
        }
        return bars;

    }
}