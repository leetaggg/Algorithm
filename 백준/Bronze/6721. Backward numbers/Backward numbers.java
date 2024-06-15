import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < n; i++) {
			String[] numbers = br.readLine().split(" ");
			int num1 = Integer.parseInt(new StringBuilder(numbers[0]).reverse().toString());
			int num2 = Integer.parseInt(new StringBuilder(numbers[1]).reverse().toString());
			int sum = num1 + num2;
			String result = new StringBuilder(String.valueOf(sum)).reverse().toString();
			System.out.println(Integer.parseInt(result));
		}
	}
}