import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		while(q.size() > 1) {
			q.poll();
			int tmp = q.peek();
			q.poll();
			q.offer(tmp);
		}
		System.out.println(q.peek());
		
	}

}
