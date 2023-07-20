import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[1001];
		arr[1] = 1;
		arr[2] = 2;
		for(int i = 3; i <= n; i++) {
			arr[i] = (arr[i - 2] + arr[i - 1]) % 10007;
		}
		System.out.println(arr[n]);
	}
}
