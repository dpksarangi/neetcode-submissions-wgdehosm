class Solution {
    public int orangesRotting(int[][] grid) {
        int count=0;
        int time=0;
        ArrayDeque<int[]> queue= new ArrayDeque<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0;j<grid[0].length; j++){
                if(grid[i][j]==1){
                    count++;
                }
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty() && count>0){
            int thismin= queue.size();
            for(int i=0; i< thismin;i++){
                int[] orange= queue.removeFirst();
                int row = orange[0];
                int col= orange[1];
                count-= rotIfFresh(grid, row+1,col,queue);
                count-= rotIfFresh(grid, row-1,col,queue);
                count-= rotIfFresh(grid, row,col+1,queue);
                count-= rotIfFresh(grid, row,col-1,queue);
            }
            time++;
        }
        return count==0?time: -1;
    }

    private int rotIfFresh(int[][] grid, int row,int col, Deque<int[]> queue){
        if(row<0||row>=grid.length||
        col<0||col>=grid[0].length||
        grid[row][col]!=1){
                return 0;
            }
            grid[row][col]=2;
            queue.addLast(new int[]{row,col});
            return 1;
    }
}
