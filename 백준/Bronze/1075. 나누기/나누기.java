import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		n /= 100;
		n *= 100;
		int f = Integer.parseInt(br.readLine());
		int result = 0;
		while (n % f != 0) {
			n++;
			result++;
		}
		if (result < 10) {
			System.out.print("0" + result);
		} else {
			System.out.print(result);
		}
	}
}