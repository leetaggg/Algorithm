import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		int result = 0;

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peek() > y) {
				result++;
				stack.pop();
			}

			if (!stack.isEmpty() && stack.peek() == y) {
				continue;
			}

			stack.push(y);
		}

		while (!stack.isEmpty()) {
			if (stack.peek() != 0) {
				result++;
			}
			stack.pop();
		}

		System.out.println(result);
	}
}