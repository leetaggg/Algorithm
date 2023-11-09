import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>(n + 1);
        int[] valArr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            graph.get(Integer.parseInt(st.nextToken())).add(i);
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            valArr[i] = Integer.parseInt(st.nextToken());
        }


        PriorityQueue<Node> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(node -> node.value)));
        pq.offer(new Node(1, valArr[1]));

        long result = 0;

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Node node = pq.poll();
            result += node.value;
            sb.append(result).append("\n");
            for (int next : graph.get(node.idx)) {
                pq.offer(new Node(next, valArr[next]));
            }
        }
        System.out.println(sb);
    }

    static class Node{
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}