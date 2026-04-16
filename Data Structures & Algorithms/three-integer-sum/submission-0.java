class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList();

        for(int i=0;i<nums.length;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int full= nums[left]+nums[i]+nums[right];
                if(full==0){
                    List<Integer> set= new ArrayList();
                    set.add(nums[i]);
                    set.add(nums[left]);
                    set.add(nums[right]);
                    result.add(set);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right --;
                }
                else if(full<0){
                    left ++;
                }else{
                    right --;
                }
            }
        }

        return result;
    }
}
