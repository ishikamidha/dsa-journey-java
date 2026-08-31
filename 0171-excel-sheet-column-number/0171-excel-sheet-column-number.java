class Solution {
    public int titleToNumber(String columnTitle) {
        int final_val = 0;
        for(int i=0;i< columnTitle.length();i++){
            int currentVal = columnTitle.charAt(i) - 'A' + 1;
            final_val = final_val * 26 + currentVal;
        }

        return final_val;
    }
}