import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while (!(line = br.readLine()).equals("0 W 0")) {
			StringTokenizer st = new StringTokenizer(line);
			int balance = Integer.parseInt(st.nextToken());
			String transaction = st.nextToken();
			int amount = Integer.parseInt(st.nextToken());

			if (transaction.equals("W")) {
				if (balance - amount < -200) {
					System.out.println("Not allowed");
				} else {
					System.out.println(balance - amount);
				}
			} else {
				System.out.println(balance + amount);
			}
		}
	}
}