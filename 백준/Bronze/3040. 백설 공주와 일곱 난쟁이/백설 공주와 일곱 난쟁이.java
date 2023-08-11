import java.io.*;

public class Main {
	static int[] arr, nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		nums = new int[7];
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		combination(0, 0);
		System.out.println(sb.toString());
	}
	
	
	public static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i : nums) {
				sum += arr[i];
			}
			if(sum == 100) {
				for(int i : nums) {
					sb.append(arr[i]).append("\n");
				}
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			nums[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}