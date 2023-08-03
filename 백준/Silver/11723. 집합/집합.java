import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] s = new boolean[21];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//연산의 수 입력받음
		int m = Integer.parseInt(st.nextToken());
		//s 는 1<= x <= 20 
		
		int num = 0;
		for (int i = 0; i < m; i++) {
			//입력
			st = new StringTokenizer(br.readLine());
			String func = st.nextToken();
			if(!(func.equals("all")||func.equals("empty")))
				num = Integer.parseInt(st.nextToken());
//			
			if(func.equals("add")) {
				s[num] = true;
			}else if(func.equals("check")) {
				if(s[num]) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
			}else if(func.equals("remove")) {
				s[num] = false;
			}else if(func.equals("toggle")) {
				if(s[num]) {
					s[num] = false;
				}else {
					s[num] = true;
				}
			}else if(func.equals("all")){
				for (int j = 0; j < s.length; j++) {
					s[j] = true;
				}
			}else if(func.equals("empty")) {
				for (int j = 0; j < s.length; j++) {
					s[j] = false;
				}
			}
		}
		System.out.println(sb);
		
		
	}

}
