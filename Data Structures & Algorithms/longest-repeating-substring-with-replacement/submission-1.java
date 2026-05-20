class Solution {
    public int characterReplacement(String s, int k) {
        int chars[]= new int[26];
        int left=0;
        int result=0;
        int maxFreq=0;

        if(s.length()<2){
            return s.length();
        }
        if(k>s.length()){
            return s.length();
        }

        for(int right=0;right<s.length();right++){
            chars[s.charAt(right)-'A']++;

            maxFreq=Math.max(maxFreq,chars[s.charAt(right)-'A']);
            int window= right-left+1;


            if(window - maxFreq > k){
                chars[s.charAt(left)-'A']--;
                left++;
            }

            result = Math.max(result,right-left+1);


        }

        return result;




    }
}
