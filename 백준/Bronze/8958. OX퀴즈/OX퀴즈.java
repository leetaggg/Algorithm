import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase++) {
            char[] ox = br.readLine().toCharArray();

            int result = 0;
            int cnt = 0;

            for (int i = 0; i < ox.length; i++) {
                if(ox[i] == 'O'){
                    cnt++;
                    result += cnt;
                }else{
                    cnt = 0;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}