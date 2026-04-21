class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int maxprofit=0;
        for(int i=0;i<prices.length;i++){
            min=Math.min(prices[i],min);
            int profit= prices[i]-min;
            maxprofit=Math.max(profit,maxprofit);
        }

        return maxprofit;
    }
}
