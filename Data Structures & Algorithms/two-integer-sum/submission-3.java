class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> store= new HashMap();
        for(int i=0;i<nums.length;i++){
            if(store.containsKey(nums[i])){
                result[1]=i;
                result[0]=store.get(nums[i]);
                return result;
            }
            store.put(target-nums[i],i);
        }
        return result;
    }
}
