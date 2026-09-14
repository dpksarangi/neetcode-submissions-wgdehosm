class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int[] dp = new int[days.length];
        Arrays.fill(dp,-1);

        return solve(0,days,costs,dp);
        
    }

    public static int solve(int i, int[] days, int[] costs, int[] dp){
        if(i>= days.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int cost1= costs[0]+ solve(i+1,days,costs,dp);
        int next7 = i;
        while(next7 <days.length && days[next7]< days[i]+7){
            next7++;
        }
        int cost7= costs[1]+ solve(next7,days,costs,dp);

        int next30 = i;
        while(next30 <days.length && days[next30]< days[i]+30){
            next30++;
        }
        int cost30= costs[2]+ solve(next30,days,costs,dp);

        dp[i]= Math.min(cost1,Math.min(cost7,cost30));

        return dp[i];

    }
}