import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		Stack<int[]> s = new Stack<>();
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			//top이 0이거나 들어온 값이  스택에 있는 값보다 클 경우에
			while(!s.isEmpty()) {
				if(s.peek()[1] >= value) {
					sb.append(s.peek()[0]+1).append(" ");
					break;
				}
				s.pop();
			}
			if (s.isEmpty()) {
				sb.append(0).append(" ");
			}
				
			s.push(new int[] {i, value});
//			System.out.println(Arrays.toString(arr));
		}
		//구현
		System.out.println(sb);

	}

}
