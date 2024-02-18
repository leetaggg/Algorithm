import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        char[] friendsTracks = new char[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            friendsTracks[i] = st.nextToken().charAt(0);
        }
        
        char helloBit = br.readLine().charAt(0);
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            if(friendsTracks[i] == helloBit) result++;
        }

        System.out.println(result);
    }
}