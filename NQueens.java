package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
	public static List<List<String>> solveNQueens(int n) {
        char[][] map = new char[n][n];
        List<List<String>> output = new LinkedList<List<String>>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                map[row][col] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(output, map, n, i);
        }
        return output;
    }

    public static boolean isValidHorizontal(char[][] map, int N, int x, int y) {
        if (x >= 0 && x < N &&  y >= 0 && y < N) {
            for (int j = 0; j < N; j++) {
                if (map[x][j] == 'Q') {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;
    }

        public static boolean isValidVertical(char[][] map, int N, int x, int y) {
        if (x >= 0 && x < N &&  y >= 0 && y < N) {
            for (int j = 0; j < N; j++) {
                if (map[j][y] == 'Q') {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;
    }

        public static boolean isValidDiagonal(char[][] map, int N, int x, int y) {
        if (x >= 0 && x < N &&  y >= 0 && y < N) {
            for (int j = 1; j < N; j++) {
                if (x - j >= 0 && x - j < N && y - j >= 0 && y - j < N) {
                    if (map[x-j][y-j] == 'Q') {
                        return false;
                    }
                }

                if (x - j >= 0 && x - j < N && y + j >= 0 && y + j < N) {
                    if (map[x-j][y+j] == 'Q') {
                        return false;
                    }
                }
            }
 
        }
        else {
            return false;
        }
        return true;
    }


    public static void dfs(List<List<String>> output, char[][] map, int N, int row) {
        if (row == N) {
            List<String> outFirst = new LinkedList<String>();
            StringBuilder out = new StringBuilder();
            int queenCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'Q') {
                        queenCount++;
                    }
                    out.append(map[i][j]);
                }
                outFirst.add(out.toString());
                out = new StringBuilder();
            }

            if (queenCount == N) {
                output.add(outFirst);
            }
            queenCount = 0;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (isValidHorizontal(map, N, row, j) == true &&
            isValidVertical(map, N, row, j) == true &&
            isValidDiagonal(map, N, row, j) == true) {
                map[row][j] = 'Q';
                dfs(output, map, N, row+1);
                map[row][j] =  '.';
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	System.out.println(solveNQueens(n));
    }
}
