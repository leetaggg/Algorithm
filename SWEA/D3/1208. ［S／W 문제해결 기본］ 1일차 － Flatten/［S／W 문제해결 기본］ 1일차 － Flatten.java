import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr = new int[100];
		for(int test_case = 1; test_case <= 10; test_case++) {
			int dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			if(arr[99] - arr[0] == 0 ||arr[99] - arr[0] == 1) {
				System.out.println(String.format("#%d %d", test_case, arr[99] - arr[0]));
				continue;
			}
			for(int i = 0; i < dump; i++) {
				arr[0]++;
				arr[arr.length-1]--;
				Arrays.sort(arr);
				if(arr[99] - arr[0] == 0 ||arr[99] - arr[0] == 1) break;
			}
			System.out.println(String.format("#%d %d", test_case, arr[99] - arr[0]));
		}

	}

}
