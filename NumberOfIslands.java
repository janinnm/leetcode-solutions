package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NumIslands {
	
	private static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	public static int numIslands(char[][] grid) {
		int num = 0;
		int N = grid.length;
		int M = grid[0].length;
		boolean[][] vis = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == '1' && vis[i][j] == false) {
					bfs(grid, vis, N, M, new int[] {i, j});
					num++;
				}			
			}
		}
		return num;
	}
	
	public static boolean isValid(char[][] grid, int x, int y, int N, int M) {
		return x >= 0 && x < N && y >= 0 && y < M && grid[x][y] == '1';
	}
	
	public static void bfs(char[][] grid, boolean[][] vis, int N, int M, int[] curr) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(curr);
		
		while(!q.isEmpty()) {
			int[] s = q.poll();
			vis[s[0]][s[1]] = true;
			
			for (int[] d: dirs) {
				int dx = s[0] + d[0];
				int dy = s[1] + d[1];
				
				if (isValid(grid, dx, dy, N, M) == true && vis[dx][dy] == false) {
					q.offer(new int[] {dx, dy});
					vis[dx][dy] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[][] grid = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = st.nextToken().charAt(0);
			}		
		}
		
		System.out.println(numIslands(grid));
		
	}

}
