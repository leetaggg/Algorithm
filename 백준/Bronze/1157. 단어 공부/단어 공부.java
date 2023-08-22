import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toUpperCase().toCharArray();
        int[] cnt = new int[26];
        for(int i = 0; i < line.length; i++){
            cnt[line[i] - 65]++;
        }
        int idx = 0;
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if(cnt[i] > max){
                max = cnt[i];
                idx = i;
            }else if(cnt[i] == max){
                idx = -1;
            }
        }
        if(idx == -1){
            System.out.println('?');
        }else{
            System.out.println( (char)(idx + 65));
        }
    }
}