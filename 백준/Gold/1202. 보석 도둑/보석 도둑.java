import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] jewelries = new int[n][2];
		int[] bags = new int[k];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			jewelries[i][0] = m;
			jewelries[i][1] = v;
		}

		for (int i = 0; i < k; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(jewelries, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o2[1] - o1[1];
			}
			return o1[0] - o2[0];
		});

		Arrays.sort(bags);


		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int idx = 0;
		long result = 0;

		for (int i = 0; i < k; i++) {
			while (idx < n && jewelries[idx][0] <= bags[i]) {
				pq.offer(jewelries[idx++][1]);
			}

			if(!pq.isEmpty()) {
				result += pq.poll();
			}
		}

		System.out.println(result);
	}
}