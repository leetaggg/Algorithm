import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int d = 0;
        int p = 0;

        for (int i = 0; i < n; i++) {
            char win = br.readLine().charAt(0);
            if(win == 'D'){
                d++;
            }else{
                p++;
            }
            if(Math.abs(d - p) == 2) break;
        }
        System.out.println(d + ":" + p);
    }
}