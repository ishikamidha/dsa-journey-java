class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max_candies = 0;
        for(int i=0; i<candies.length;i++){
               if(candies[i]> max_candies){
                max_candies = candies[i];
               }
        }
        List<Boolean> result = new ArrayList<>();
        for(int i : candies){
            result.add(i + extraCandies >= max_candies);
        }
        return result;
        
    }
}