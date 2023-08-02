import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		combination(0, 1);
		System.out.println(sb.toString());
	}

	public static void combination(int cnt, int start) {
		if (cnt == m) {
			for (int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= n; i++) {
			arr[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
