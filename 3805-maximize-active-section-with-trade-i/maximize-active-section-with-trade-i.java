class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        int totalOnes = 0;
        int prevZeroBlock = Integer.MIN_VALUE;
        int maxGain = 0;

        int i = 0;
         while (i < n) {

            int j = i;

            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int blockLength = j - i;

            if (s.charAt(i) == '1') {

                totalOnes += blockLength;

            } else {

                maxGain = Math.max(maxGain, prevZeroBlock + blockLength);
                prevZeroBlock = blockLength;
            }

            i = j;
        }

        return totalOnes + maxGain;
        
    }
}