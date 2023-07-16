import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Queue<String> stack = new LinkedList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			while (st.hasMoreTokens()) {
				stack.offer(st.nextToken());
			}
			while(!stack.isEmpty()) {
				String oper = stack.poll();
				if(oper.equals("@")) {
					a = a * 3;
				}
				else if(oper.equals("%")) {
					a = a + 5;
				}
				else {
					a = a - 7;
				}
			}
			System.out.println(String.format("%.2f", a));
		}
		
	}

}
