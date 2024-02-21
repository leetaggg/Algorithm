import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] upArr = new int[n + 1];
        int[] downArr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());

            if(k > 0){
                upArr[k] += 1;
            }else{
                downArr[-k] += 1;
            }
        }

        int[] upPrefix = new int[n + 1];
        int[] downPrefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            upPrefix[n - i] = upArr[n - i + 1] + upPrefix[n - i + 1];
            downPrefix[i] = downArr[i - 1] + downPrefix[i - 1];
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            if(upPrefix[i] + downPrefix[i] == i) list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        if(!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
        }

        System.out.println(sb);
    }
}