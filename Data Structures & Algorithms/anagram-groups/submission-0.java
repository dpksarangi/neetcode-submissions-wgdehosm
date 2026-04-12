class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result= new ArrayList();
        for(String s : strs){
            addToResult(result,s);
        }

        return result;
    }

    public static boolean addToResult(List<List<String>> result, String s){
        for(List<String> stringList: result){
            if(isAnagram(s, stringList.get(0))){
                stringList.add(s);
                return true;
            }
            
        }
        List<String> newList= new ArrayList();
        newList.add(s);
        result.add(newList); 
        return false;
    }

    public static boolean isAnagram(String s, String t){
        if(s.length()!=t.length())
            return false;
        int[] count= new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int num: count){
            if(num!=0)
            return false;
        }

        return true;
    }
}
