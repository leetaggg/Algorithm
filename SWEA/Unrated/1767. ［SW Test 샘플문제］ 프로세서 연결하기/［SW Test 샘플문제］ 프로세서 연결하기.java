import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map;
    static int n, maxCore, minLen;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            list = new ArrayList<>();
            for (int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1){
                        list.add(new int[]{i, j});
                    }
                }
            }
            maxCore = Integer.MIN_VALUE;
            minLen = Integer.MAX_VALUE;
            dfs(0, 0, 0);
            sb.append("#").append(testCase).append(" ").append(minLen).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int idx, int core, int len){
        if(idx == list.size()){
            if(maxCore < core){
                maxCore = core;
                minLen = len;
            } else if (maxCore == core) {
                minLen = Math.min(minLen, len);
            }
            return;
        }

        int x = list.get(idx)[0];
        int y = list.get(idx)[1];
        for (int[] dr : dir){
            int nx = x;
            int ny = y;
            int tempLen = 0;
            while(true){
                nx += dr[0];
                ny += dr[1];

                if(nx < 0 || n <= nx || ny < 0 || n <= ny) break;
                if(map[nx][ny] == 1){
                    tempLen = 0;
                    break;
                }

                tempLen++;
            }
            for (int i = 0; i < tempLen; i++) {
                x+=dr[0];
                y+=dr[1];
                map[x][y] = 1;
            }
            if(tempLen == 0){
                dfs(idx + 1, core, len);
            }else{
                dfs(idx + 1, core + 1, len + tempLen);
            }
            for (int i = 0; i < tempLen; i++) {
                map[x][y] = 0;
                x -= dr[0];
                y -= dr[1];
            }
        }
    }
}