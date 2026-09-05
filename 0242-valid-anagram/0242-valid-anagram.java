class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        boolean[] used = new boolean[t.length()];

        for(int i=0;i< s.length();i++){
               char charS = s.charAt(i);
               boolean matched = false;

               for(int j=0;j<t.length();j++){
                if(!used[j] && t.charAt(j)==charS){
                    used[j] = true;
                    matched =  true;
                    break;
                }
               }
               if(!matched){
                return false;
               }
        }
        return true;


        
    }
}