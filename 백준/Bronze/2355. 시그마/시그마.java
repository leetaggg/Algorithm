import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long a = Math.min(n, m);
		long b = Math.max(n, m);
		long sum = (a + b) * ((b - a + 1) / 2);

		if((b - a + 1) % 2 != 0) {
			sum += (a + b) / 2;
		}
		System.out.println(sum);
	}
}