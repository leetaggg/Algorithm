import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> result = new ArrayList<>();
	static int[] arr;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}

		Collections.sort(result);

		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int idx, int n) {
		if (arr[idx] == n) {
			result.add(n);
			return;
		}

		if (!visited[arr[idx]]) {
			visited[arr[idx]] = true;
			dfs(arr[idx], n);
			visited[arr[idx]] = false;
		}
	}
}
