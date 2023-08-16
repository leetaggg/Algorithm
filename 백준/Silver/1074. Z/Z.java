import java.io.*;
import java.util.*;

public class Main {
    static int n, r, c, cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cnt= 0;
        dv(0, 0, 1 << n, 0);
        System.out.println(cnt);
    }

    public static void dv(int x, int y, int size, int result){
        if(size == 1){
            if(x == r && y == c) {
                cnt = result;
                return;
            }
            return;
        }

        int length = size / 2;
        if(x <= r && r < x + length && y <= c && c < y + length) dv(x, y, length, result);
        if(x <= r && r < x + length && y + length <= c && c < y + length * 2) dv(x, y + length, length, result + (size * size) / 4);
        if(x + length<= r && r < x + length * 2 && y <= c && c < y + length) dv(x + length, y, length, result + (size * size) / 4 * 2);
        if(x + length <= r && r < x + length * 2 && y + length <= c &&  c < y + length * 2) dv(x + length, y + length, length, result + (size * size) / 4 * 3);
    }
}
