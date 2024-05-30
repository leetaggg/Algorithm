import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int count = 0;

		for (int ab = 0; ab < 100; ab++) {
			for (int cd = 0; cd < 100; cd++) {
				if (n - ab - cd == 0) {
					count++;
				}
			}
		}

		System.out.println(count);
	}
}