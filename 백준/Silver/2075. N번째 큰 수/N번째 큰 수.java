import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < n; i++) {
			if(i == n - 1){
				System.out.println(pq.poll());
			}
			pq.poll();
		}
	}
}