import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		arr = new int[m];
		permutation(0);
		System.out.println(sb.toString());
	}

	public static void permutation(int cnt) {
		if (cnt == m) {
			for (int num : arr){
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				arr[cnt] = i;
				visited[i] = true;
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
