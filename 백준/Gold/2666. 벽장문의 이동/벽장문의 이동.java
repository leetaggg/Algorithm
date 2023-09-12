import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int num;
    private static int[] bookwall;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //n개의 같은 크기의 벽장
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] door = new int[2];
        door[0] = Integer.parseInt(st.nextToken());
        door[1] = Integer.parseInt(st.nextToken()); //문 두개
        Arrays.sort(door);
        
        num = Integer.parseInt(br.readLine());
        
        bookwall = new int[num];
        for (int i = 0; i < num; i++) {
            bookwall[i] = Integer.parseInt(br.readLine()); //사용할 벽장 수
        } //입력 끝
        
        //구현
      
        System.out.println(dfs(0, door[0], door[1]));
        
    }

//    private static int min = Integer.MAX_VALUE;
    
    private static int dfs(int depth, int door1, int door2) {
        //기저조건
        if(depth == num) {
            //모든걸 다 돌았다면 리턴
            return 0;
        }

        //dfs(횟수-깊이, 문1, 문2 target)
        int answer1 = dfs(depth+1, door1, bookwall[depth]) + Math.abs(door2-bookwall[depth]);
        
        int answer2 = dfs(depth+1, bookwall[depth], door2) + Math.abs(door1-bookwall[depth]);

        // 값 다시 비교
        return Math.min(answer1, answer2);
     }
        
}
