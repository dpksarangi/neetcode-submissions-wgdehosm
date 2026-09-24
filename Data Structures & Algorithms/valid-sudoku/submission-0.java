class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows= new HashSet[9];
        Set<Character>[] cols= new HashSet[9];
        Set<Character>[] sqr= new HashSet[9];

        for (int i = 0; i < 9; i++) {
        rows[i] = new HashSet<>();
        cols[i] = new HashSet<>();
        sqr[i] = new HashSet<>();
        }
        for(int i=0;i<board.length; i++){

            for(int j=0; j<board[0].length;j++){
                char c= board[i][j];
                if(c=='.') continue;
                int sqnum= (i/3)*3+(j/3);
                if(rows[i].contains(c) || 
                    cols[j].contains(c)||
                    sqr[sqnum].contains(c)){
                    return false;
                }
                rows[i].add(c);
                cols[j].add(c);
                sqr[sqnum].add(c);
           }
        }

        return true;
    }
}
