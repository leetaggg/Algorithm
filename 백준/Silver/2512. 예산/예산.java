import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] arr;
	private static int budget;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		budget = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = max+1;
		
		while(left+1 < right) {
			int target = (left + right)/2;
			
			if(!check(target)) {
				right = target;
			}else {
				left = target;
			}
		}
		
		System.out.println(left);
	}// end main

	private static boolean check(int target) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if(target <= arr[i]) {
				sum += target;
			}else {
				sum += arr[i];
			}
		}
		
		if(sum > budget) {
			return false;
		}
		return true;
	}
}//end class
