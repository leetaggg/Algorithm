import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> artSizes = new ArrayList<>();
    static int[][] map;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n, m, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        artSizes.sort(Collections.reverseOrder());
        System.out.println(cnt);
        if (cnt == 0) {
            System.out.println(0);
        } else {
            System.out.println(artSizes.get(0));
        }
    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        map[i][j] = 2;
        int size = 1;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dir : dirs) {
                int dr = node[0] + dir[0];
                int dc = node[1] + dir[1];
                if (0 <= dr && dr < n && 0 <= dc && dc < m && map[dr][dc] == 1) {
                    map[dr][dc] = 2;
                    size++;
                    q.offer(new int[]{dr, dc});
                }
            }
        }
        artSizes.add(size);
    }
}