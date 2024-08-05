import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		while (q.size() > 1) {
			sb.append(q.poll()).append(" ");
			q.offer(q.poll());
		}
		sb.append(q.poll());
		System.out.println(sb);
	}
}
