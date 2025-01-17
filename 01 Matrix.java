// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j <matrix[0].length ; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = -1;  
                } 
                else{
                    q.add(new int[]{i,j});  
                } 
            }
        }
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir:dirs){
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == -1){
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                    q.add(new int[]{r,c});
                }
            }                
        }
        return matrix;    
    }
}
