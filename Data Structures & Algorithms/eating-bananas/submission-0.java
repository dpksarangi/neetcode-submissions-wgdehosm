class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        
        while (left <right){
            int mid=(right+left) /2;
            if(canFinish(piles,mid,h)){
                right=mid;
            }
            else
            left=mid+1;
        }

        return left;
    }

    public boolean canFinish(int[] piles, int rate, int h){
        int hours=0;
        for(int pile: piles){
            hours+= (pile+rate-1)/rate;
        }

        return hours <=h;
    }
}
