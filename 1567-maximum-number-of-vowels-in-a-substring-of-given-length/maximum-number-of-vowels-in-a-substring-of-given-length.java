class Solution {
    private boolean isVowel(char n){
        if(n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u'){
            return true;
        }else{
            return false;
        }
    }
    public int maxVowels(String s, int k) {
        char arr[] = s.toCharArray();
        int count = 0;

        for(int i = 0;i<k;i++){
            if(isVowel(arr[i])){
                count++;
             }
        } 
        int max = count;

        for(int i = k;i<arr.length;i++){
            if(isVowel(arr[i])){
                count++;
            }
            if(isVowel(arr[i-k])){
                count--;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}