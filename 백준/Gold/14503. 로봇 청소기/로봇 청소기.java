import java.io.*;
import java.util.*;


public class Main {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 위0 오른1 아래2 왼3
    static int[][] room;
    static Robot robot;
    static int r, c, cleanCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken()); // 방 크기 r
        c = Integer.parseInt(st.nextToken()); // 방 크기 c
        room = new int[r][c];
        st = new StringTokenizer(br.readLine(), " ");
        robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 로봇 생성

        for (int i = 0; i < r; i++) { // 방 초기화
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cleanCnt = 0;
        clean(robot);
        System.out.println(cleanCnt);
    }
    static void clean(Robot rb){
        int rbR = rb.r;
        int rbC = rb.c;
        int rbD = rb.dir;

        if(room[rbR][rbC] == 0){
            room[rbR][rbC] = -1;
            cleanCnt++;
        }

        for (int i = 3; i >= 0; i--) { // 5번, 청소되지 않은 빈칸이 있는 경우,
            int aroundD = (rbD + i) % 4;
            int aroundR = rbR + dir[aroundD][0];
            int aroundC = rbC + dir[aroundD][1];
            if(0 <= aroundR && aroundR < r && 0 <= aroundC && aroundC < c && room[aroundR][aroundC] == 0){
                rb.r = aroundR;
                rb.c = aroundC;
                rb.dir = aroundD;
                clean(rb);
                return;
            }
        }
        move(rb);
    }
    static void move(Robot rb){
        int rbR = rb.r;
        int rbC = rb.c;
        int rbD = rb.dir;
        int moveR = rbR + dir[(rbD + 2) % 4][0];
        int moveC = rbC + dir[(rbD + 2) % 4][1];
        if( 0 <= moveR && moveR < r && 0 <= moveC && moveC < c && room[moveR][moveC] != 1){
            rb.r = moveR;
            rb.c = moveC;
            clean(rb);
        }

    }
    static class Robot{
        int r;
        int c;
        int dir; // 위0 오른1 아래2 왼3
        Robot(int r, int c, int dir){
            super();
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}
