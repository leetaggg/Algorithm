import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String com = st.nextToken();

            switch (com){
                case "push_front":
                    q.offerFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    q.offerLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    if(q.isEmpty()){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(q.pollFirst()).append("\n");
                    }
                    break;

                case "pop_back":
                    if(q.isEmpty()){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(q.pollLast()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    if(q.isEmpty()){
                        sb.append("1").append("\n");
                    }else{
                        sb.append("0").append("\n");
                    }
                    break;

                case "front":
                    if(q.isEmpty()){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(q.peekFirst()).append("\n");
                    }
                    break;

                case "back":
                    if(q.isEmpty()){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(q.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);

    }
}