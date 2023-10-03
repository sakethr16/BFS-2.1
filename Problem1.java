/*
 
Rotting Oranges(https://leetcode.com/problems/rotting-oranges)

TC : O(m*n)
SC : O(m*n)
Leet Code :

 */

 class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length ==0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 ){
                        q.add(new int[] {nr,nc});
                        grid[nr][nc] = 2;
                        fresh --;
                    }
                }
            }
            time++;
        }

        if(fresh != 0){
            return -1;
        }
        return time-1;
    }
}