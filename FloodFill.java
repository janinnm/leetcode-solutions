class Solution {

    private static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static boolean isValid(int[][] image, int x, int y) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        bfs(image, sr, sc, color);

        return image;
    }

    public static void bfs(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[image.length][image[0].length];
        q.offer(new int[] {sr, sc});
        int initialColor = image[sr][sc];
        image[sr][sc] = color;

        while(!q.isEmpty()) {
            int[] s = q.poll();

            for (int[] d: dirs) {
                int dx = s[0] + d[0];
                int dy = s[1] + d[1];

                if (isValid(image, dx, dy) == true && vis[dx][dy] == false) {

                    if (image[dx][dy] == initialColor) {
                        image[dx][dy] = color;
                        q.offer(new int[] {dx, dy});
                    }
                    vis[dx][dy] = true;               
                }
            }
        }
    }
}
