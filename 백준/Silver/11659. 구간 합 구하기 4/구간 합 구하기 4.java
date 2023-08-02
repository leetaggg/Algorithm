import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long[] sumArr = new long[n + 1];
		sumArr[0] = arr[0];
		for(int i = 1; i <= n; i++) {
			sumArr[i] = sumArr[i-1] + arr[i-1];
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			sb.append(sumArr[two] - sumArr[one - 1]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
