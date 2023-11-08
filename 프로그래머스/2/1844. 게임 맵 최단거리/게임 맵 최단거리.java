import java.util.*;

class Solution {
    int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //북남서동
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        int answer = dfs(maps, n, m);
        
        return answer;
    }
    
    public int dfs(int[][] maps, int n, int m){
        Queue<Location> queue = new ArrayDeque<Location>();
        queue.offer(new Location(0, 0, 1));
        
        while(!queue.isEmpty()){
            Location current = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m 
                   || maps[nr][nc] <= 0){
                    continue; //범위 확인, 방문처리
                }
                if(nr == n-1 && nc == m-1){
                    return current.cnt+1;
                }
                
                queue.offer(new Location(nr, nc, current.cnt+1));
                maps[nr][nc] = -1; //방문처리
                
            }//end for
            
        }//end while
        return -1;
    }//end dfs
    
    public class Location{
        int r;
        int c;
        int cnt;
        
        public Location(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}