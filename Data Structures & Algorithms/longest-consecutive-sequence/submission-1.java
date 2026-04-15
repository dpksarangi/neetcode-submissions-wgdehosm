class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set= new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int max=0;

        for(int num: nums){
            if(!set.contains(num-1)){
                int current= num;
                int len=1;
                while(set.contains(current+1)){
                    current++;
                    len++;
                }
                max=Math.max(len,max);

            }

        }


        return max;
    }
    
}
