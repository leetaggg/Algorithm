import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "push":
                    dq.offer(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(dq.isEmpty()){
                        sb.append(-1);
                    }else{
                        sb.append(dq.pollFirst());
                    }
                    sb.append("\n");
                    break;

                case "size":
                    sb.append(dq.size()).append("\n");
                    break;

                case "empty":
                    if(dq.isEmpty()){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;

                case "front":
                    if(dq.isEmpty()){
                        sb.append(-1);
                    }else{
                        sb.append(dq.peekFirst());
                    }
                    sb.append("\n");
                    break;

                case "back":
                    if(dq.isEmpty()){
                        sb.append(-1);
                    }else{
                        sb.append(dq.peekLast());
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}