import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int n = Integer.parseInt(br.readLine());
		boolean flag = true;
		int x = 2;
		if(n == 1) {
			return;
		}
		while(flag) {
			if(n % x == 0) {
				n = n / x;
				sb.append(x).append("\n");
			}
			else {
				x++;
			}
			if(n == 1) flag = false;
		}
		System.out.println(sb.toString());	
	}
}