import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(" ");
		}

		System.out.println(sb);
	}

	public static int lowerBound(int[] arr, int key) {
		int left = 0;
		int right = arr.length;

		while (left < right) {
			int mid = (left + right) / 2;
			if (key <= arr[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static int upperBound(int[] arr, int key) {
		int left = 0;
		int right = arr.length;

		while (left < right) {
			int mid = (left + right) / 2;
			if (key < arr[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
