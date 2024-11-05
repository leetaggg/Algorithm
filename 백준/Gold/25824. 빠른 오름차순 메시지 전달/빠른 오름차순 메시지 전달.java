import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[12][12];

		for (int i = 0; i < 12; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 12; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = Integer.MAX_VALUE;

		dfs(0,arr[0][1], 1);
		dfs(1,arr[1][0], 1);

		System.out.println(result);
	}

	static void dfs(int cur, int sum, int depth) {
		if (depth == 6) {
			if(sum < result) {
				result = sum;
			}
			return;
		}

		dfs(depth * 2 + 1, sum + arr[cur][depth * 2] + arr[depth * 2][depth * 2 + 1], depth + 1);
		dfs(depth * 2, sum + arr[cur][depth * 2 + 1] + arr[depth * 2 + 1][depth * 2], depth+1);
	}
}