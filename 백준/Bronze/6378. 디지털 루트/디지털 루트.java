import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while ((line = br.readLine()) != null) {
			if (line.equals("0")) {
				break;
			}

			int digitalRoot = calculateDigitalRoot(line);
			System.out.println(digitalRoot);
		}
	}

	static int calculateDigitalRoot(String number) {
		while (number.length() > 1) {
			int sum = 0;
			for (char digit : number.toCharArray()) {
				sum += digit - '0';
			}
			number = Integer.toString(sum);
		}
		return Integer.parseInt(number);
	}
}