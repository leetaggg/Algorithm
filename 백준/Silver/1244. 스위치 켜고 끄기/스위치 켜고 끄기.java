import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n + 1];
		arr[0] = -1;
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int student = Integer.parseInt(br.readLine());
		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			onoff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
			if(i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	public static void onoff(int gen, int num) {
		if(gen == 1) {
			for(int i = num; i <= n; i += num) {
				arr[i] = arr[i] == 0 ? 1 : 0;
			}
		}
		else {
			int j = 1;
			arr[num] = arr[num] == 0 ? 1 : 0;
			while(true) {
				if(num + j > n || num - j < 0) break;
				if(arr[num + j] != arr[num - j]) break;
				arr[num + j] = arr[num + j] == 0 ? 1 : 0;
				arr[num - j] = arr[num - j] == 0 ? 1 : 0;
				j++;
			}
		}
	}
}
