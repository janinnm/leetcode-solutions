package practice;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingPath {

	    private static int[][] dirs = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
	    private static int max;

	    public static boolean isValid(int[][] matrix, int x, int y) {
	        return x < matrix.length && x >= 0 && y < matrix[0].length && y >= 0;
	    }

	    public static void dfs(int[][] matrix, int x, int y, int currMax, int pathSize, boolean[][] vis){
	        if (matrix[x][y] <= currMax) {
	            max = Math.max(max, pathSize);
	        }
	        
	        vis[x][y] = true;
	        int oldCurrMax = currMax;
	        for (int[] d: dirs) {
	            int dx = x + d[0];
	            int dy = y + d[1];

	            if (isValid(matrix, dx, dy) == true && vis[dx][dy] == false) {
	            	vis[dx][dy] = true;

	            	if (matrix[dx][dy] > currMax) {
		                pathSize+=1;
		                currMax = matrix[dx][dy];
		                dfs(matrix, dx, dy, currMax, pathSize, vis);
		                currMax = oldCurrMax;
		                pathSize-=1;            		
	            	}
	            	vis[dx][dy] = false;
	            }

	        }
	    }
	 
	    public static int longestIncreasingPath(int[][] matrix) {
	    	max = 0;
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                boolean[][] vis = new boolean[matrix.length][matrix[0].length];
	                int currMax = matrix[i][j];
	                int pathSize = 1;
	                dfs(matrix, i, j, currMax, pathSize, vis);
	            }
	        }
	    return max;
	    } 
	    
	    public static void main(String[] args) throws Exception {
//	    	int[][] matrix = new int[][] { {9,9,4},{6,6,8},{2,1,1}};
	    	int[][] matrix = new int[][] { {1}};
	    	System.out.println(longestIncreasingPath(matrix));
	    }

}
