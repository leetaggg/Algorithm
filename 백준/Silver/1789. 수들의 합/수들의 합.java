import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long sum = 0;
		long x = 1;
		long cnt = 0;
		while(sum <= n) {
			sum += x;
			cnt++;
			x++;
		}
		if(sum > n) {
			System.out.println(cnt-1);
		}
		else {
			System.out.println(cnt);
		}

	}

}
