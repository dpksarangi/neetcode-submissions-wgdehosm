class Solution {
    public int orangesRotting(int[][] grid) {
        int minute=0;
        Queue<int[]> rotten= new ArrayDeque<>();
        int fresh=0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[0].length;j++){
                if(grid[i][j]==1) fresh ++;
                else if(grid[i][j]==2) rotten.offer(new int[] {i,j});
            }
        }

        while (!rotten.isEmpty() && fresh > 0){
            int size= rotten.size();
            for(int i=0; i< size;i++){
                int[] cur=rotten.poll();
                if(cur[0]+1<grid.length && grid[cur[0]+1][cur[1]]==1){
                    fresh --;
                    rotten.offer(new int[]{cur[0]+1,cur[1]});
                    grid[cur[0]+1][cur[1]]=2;
                }
                if(cur[0]-1>=0 && grid[cur[0]-1][cur[1]]==1){
                    fresh --;
                    rotten.offer(new int[]{cur[0]-1,cur[1]});
                    grid[cur[0]-1][cur[1]]=2;
                }
                if(cur[1]+1 < grid[0].length && grid[cur[0]][cur[1]+1]==1){
                    fresh --;
                    rotten.offer(new int[]{cur[0],cur[1]+1});
                    grid[cur[0]][cur[1]+1]=2;
                }
                if(cur[1]-1 >= 0 && grid[cur[0]][cur[1]-1]==1){
                    fresh --;
                    rotten.offer(new int[]{cur[0],cur[1]-1});
                    grid[cur[0]][cur[1]-1]=2;
                }
            }
            minute++;
        }

        return fresh==0?minute:-1;
    }
}
