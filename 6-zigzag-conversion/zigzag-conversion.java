class Solution {
    public String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows == 1){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i= 0;i<numRows;i++){
            rows[i] = new StringBuilder();
        }
        int currRow = 0;
        boolean goingDown = true;

        for(char ch: s.toCharArray()){
            rows[currRow].append(ch);

            if(currRow == numRows - 1){
                goingDown = false;
            }
            else if(currRow == 0){
                goingDown = true;
            }

            if(goingDown){
                currRow++;
            }else
            {
                currRow--;
            }
        }
        StringBuilder ans =  new StringBuilder();
        for(StringBuilder row : rows){
            ans.append(row);
        }
        return ans.toString();

    }
}