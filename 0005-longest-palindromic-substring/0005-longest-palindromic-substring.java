class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.isEmpty())return "";
        int start = 0;
        int best=1;
        for(int c=0;c<s.length();c++){
            for(int w=0;w<2;w++){
                int l= c;
                int r= c+w;
                while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                    l--;
                    r++;
                }
                int len = r-l-1;
                if(len>best){
                    best=len;
                    start=l+1;
                }
            }
        }
        return s.substring(start,start+best);
    }
}