class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int max=0;
        if(s.length()<2){
            return s.length();
        }
        Map<Character, Integer> store= new HashMap();
        for(int i=0; i<s.length();i++){
            char ch= s.charAt(i);
            if(store.containsKey(s.charAt(i))){
                left = Math.max(store.get(ch)+1,left);
            }
            store.put(ch,i);
            max=Math.max(max,i-left+1);
        }
        return max;
    }
}
