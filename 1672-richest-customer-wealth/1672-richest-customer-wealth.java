class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int ans = Integer.MIN_VALUE;
        for(int[] customer : accounts){
            int sum = 0;
            for(int bank_balance : customer){
                sum+=bank_balance;
            }
            if(sum > ans){
            ans = sum;
        }
        }
        
    return ans;
    }
}