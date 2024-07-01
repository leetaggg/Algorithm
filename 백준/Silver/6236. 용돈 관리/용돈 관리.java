import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		int start = 1, end = 1;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(start < arr[i]) {
				start = arr[i];
			}
			end += arr[i];
		}


		int mid, sum, cnt;
		while (start <= end) {
			mid = (start + end) / 2;

			cnt = 1;
			sum = 0;

			for (int num : arr) {
				sum += num;
				if (sum > mid) {
					sum = num;
					cnt++;
				}

			}

			if (cnt > m) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(start);
	}
}