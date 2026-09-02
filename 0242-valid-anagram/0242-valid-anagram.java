class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        else{
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();

        Arrays.sort(s_array);
        Arrays.sort(t_array);
        
        if(Arrays.equals(s_array,t_array)){
            return true;
        }else{
            return false;
        }
        


        }
    }
}