import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int zzak = 0;
        int hol = 0;

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());

            if(k % 2 == 0){
                zzak++;
            }else{
                hol++;
            }
        }

        System.out.println(zzak > hol ? "Happy" : "Sad");
    }
}