import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int[] arr;
	private static int n;
	private static int m;
	private static boolean[] isSelected;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 입력 수
		m = Integer.parseInt(st.nextToken()); // 뽑을 개수
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}// 입력 완료
		Arrays.sort(arr);
		
		numbers = new int[m]; //수열을 담을 배열
		isSelected = new boolean[n]; //중복을 막을 배열
		
		per(0);
		System.out.println(sb.toString());

	}//end main
	

	public static void per(int cnt) {
		//기저조건
		if(cnt == m) {
			print(numbers);
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!isSelected[i]) {
				numbers[cnt] = arr[i];
				isSelected[i] = true;
				per(cnt+1);
				isSelected[i] = false;
			}
			
		}
	}//end per
	
	public static void print(int[] numbers) {
		
		for (int i : numbers) {
			sb.append(i).append(" ");
		}
		sb.append("\n");
	}// end print

}//end class
