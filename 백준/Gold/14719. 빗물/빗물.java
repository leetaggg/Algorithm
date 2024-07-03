import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] arr = new int[w];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		int start = 0, tmp = 0, result = 0;
		for (int i = 0; i < w; i++) {
			if (start > arr[i]) {
				tmp += start - arr[i];
			} else {
				result += tmp;
				start = arr[i];
				tmp = 0;
			}
		}

		start = 0;
		tmp = 0;
		for (int i = w - 1; i >= 0; i--) {

			if (start > arr[i]) {
				tmp += start - arr[i];
			} else {
				result += tmp;
				start = arr[i];
				tmp = 0;
			}

			if(arr[i] == max) break;
		}

		System.out.println(result);
	}
}