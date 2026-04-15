class Solution {
    public boolean isPalindrome(String s) {
        
        String snew= s.replaceAll("[^A-Za-z0-9]","");
        int n= snew.length();
        snew= snew.toLowerCase();
        if(n<=0){
            return true;
        }
        for(int i=0;i<=n/2;i++){
            if(snew.charAt(i)!=snew.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}
