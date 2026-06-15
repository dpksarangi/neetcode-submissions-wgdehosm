class Solution {
    public int findMin(int[] nums) {

        int left =0;
        int right = nums.length-1;
        if(nums[right]>nums[left]){
            return nums[left];
        }

        while(left<right){
            int mid= (left + right )/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
            

        }

        return nums[left];

        
    }
}


// 345612 
