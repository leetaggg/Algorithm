import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String num1 = st.nextToken();
			String num2 = st.nextToken();

			if (num1.equals("0") && num2.equals("0")) {
				break;
			}

			int carryCount = 0;
			int carry = 0;
			int maxLength = Math.max(num1.length(), num2.length());

			for (int i = 0; i < maxLength; i++) {
				int digit1 = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
				int digit2 = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;

				int sum = digit1 + digit2 + carry;

				if (sum >= 10) {
					carry = 1;
					carryCount++;
				} else {
					carry = 0;
				}
			}

			System.out.println(carryCount);
		}
	}
}
