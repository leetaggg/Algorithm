import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] sumArr = new int[n + 2];

		while (m --> 0) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			sumArr[to] += num;
			sumArr[from + 1] -= num;
		}

		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += sumArr[i];
			sb.append(arr[i] + sum).append(" ");
		}

		System.out.println(sb);
	}
}
