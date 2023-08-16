import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());//testcase
		
		for (int test_case = 0; test_case < t; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //a의 수
			int m = Integer.parseInt(st.nextToken()); //b의 수
			
			Integer[] a = new Integer[n];
			Integer[] b = new Integer[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a, Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(b, Collections.reverseOrder());
			
			int s = 0;
			int answer = 0;
			for (int i = 0; i < m; i++) {
				while(s < n && b[i] < a[s]) s++;
				answer += s;
//				System.out.println("i값:"+i+"지점:"+s);
			}
			
			sb.append(answer).append("\n");
		}//end test_case
		System.out.println(sb);
		
	}

}
