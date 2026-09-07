import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> array =new HashSet<>();
        for(int num : nums){
            if(array.contains(num)){
                return true;
            }
            array.add(num);
        }
        return false;
    }
}