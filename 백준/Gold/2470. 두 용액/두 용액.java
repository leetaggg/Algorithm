import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int leftValue = arr[0];
		int rightValue = arr[n - 1];

		int min = Integer.MAX_VALUE;

		int start = 0;
		int end = n - 1;
		while(start < end) {
			int sum = arr[start] + arr[end];

			if(Math.abs(min) > Math.abs(sum)) {
				min = sum;
				leftValue = arr[start];
				rightValue = arr[end];
			}

			if(sum < 0) {
				start++;
			} else if (sum == 0) {
				break;
			} else {
				end--;
			}
		}

		System.out.println(leftValue + " " + rightValue);
	}
}