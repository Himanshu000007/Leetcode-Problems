class Solution {
    public int maxProfit(int[] prices) {
        int minp = Integer.MAX_VALUE;
        int mxp = 0;
        for(int p : prices){
            if(p < minp){
                minp = p;
            }else{
                int pf = p - minp;
                mxp = Math.max(mxp,pf);
            }
        }
        return mxp;
    }
}