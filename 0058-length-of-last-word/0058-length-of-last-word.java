class Solution {
    public int lengthOfLastWord(String s) {
        
        String[] words= s.trim().split("\\s+");
        String last_word=  words[words.length - 1];

        return last_word.length();

        
    }
}