class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> list = new ArrayList<>();
        int max = 0;
        for(int i = 0;i<candies.length;i++){
            max = Math.max(candies[i],max);
        }
        for(int i =0;i<candies.length;i++){
            if(candies[i] + extraCandies < max){
                list.add(false);
            }else{
                list.add(true);
            }
        }
        return list;
    }
}