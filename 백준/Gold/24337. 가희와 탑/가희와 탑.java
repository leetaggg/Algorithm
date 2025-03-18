import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		if (a + b - 1 > n) {
			System.out.println(-1);
			return;
		}

		int max = Math.max(a, b);

		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = b - 1; i >= 1; i--) {
			dq.offerLast(i);
			n--;
		}

		if (a != 1) {
			dq.offerFirst(max);
			n--;

		}

		for (int i = a - 1; i >= 1; i--) {
			dq.offerFirst(i);
			n--;
		}

		if (a == 1) {
			n--;
		}

		for (int i = 0; i < n; i++) {
			dq.offerFirst(1);
		}

		if (a == 1) {
			dq.offerFirst(max);
		}

		StringBuilder sb = new StringBuilder();

		while (!dq.isEmpty()) {
			sb.append(dq.pollFirst() + " ");
		}

		System.out.println(sb);
	}
}