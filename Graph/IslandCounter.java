import java.util.*;

class IslandCounter {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    void dfs(int[][] g, int i, int j) {
        if (i<0 || j<0 || i>=g.length || j>=g[0].length || g[i][j]==0) return;

        g[i][j] = 0;

        for (int[] d : dir)
            dfs(g, i+d[0], j+d[1]);
    }

    int countDFS(int[][] g) {
        int c = 0;
        for (int i=0;i<g.length;i++) {
            for (int j=0;j<g[0].length;j++) {
                if (g[i][j] == 1) {
                    dfs(g, i, j);
                    c++;
                }
            }
        }
        return c;
    }

    int countBFS(int[][] g) {
        int c = 0;
        for (int i=0;i<g.length;i++) {
            for (int j=0;j<g[0].length;j++) {
                if (g[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    g[i][j] = 0;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int[] d : dir) {
                            int x = cur[0]+d[0];
                            int y = cur[1]+d[1];

                            if (x>=0 && y>=0 && x<g.length && y<g[0].length && g[x][y]==1) {
                                g[x][y]=0;
                                q.add(new int[]{x,y});
                            }
                        }
                    }
                    c++;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1,1,0,0,0},
            {1,1,0,0,1},
            {0,0,1,0,1},
            {0,0,0,1,1}
        };

        IslandCounter ic = new IslandCounter();
        System.out.println(ic.countDFS(grid));
    }
}