import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 0, sum = 0;

		int len = Integer.MAX_VALUE;
		while (right <= n) {
			if (sum >= s) {
				sum -= arr[left++];
				if (len > right - left + 1) {
					len = right - left + 1;
				}
			} else {
				sum += arr[right++];
			}
		}

		System.out.println(len == Integer.MAX_VALUE ? 0 : len);
	}
}
