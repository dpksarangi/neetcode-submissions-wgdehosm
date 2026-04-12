class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character,Integer> list= new HashMap();
        for(int i=0; i<s.length();i++){
            list.put(s.charAt(i),list.getOrDefault(s.charAt(i),0)+1);
            list.put(t.charAt(i), list.getOrDefault(t.charAt(i), 0) -1);
        }

        
        for(Character c: list.keySet()){
            if(list.get(c)!=0){
                return false;
            }
        }

            return true;
    }
}
