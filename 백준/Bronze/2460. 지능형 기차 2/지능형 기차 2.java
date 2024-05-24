import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxPeople = 0;
		int currentPeople = 0;

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());

			currentPeople = currentPeople - out + in;
			if (currentPeople > maxPeople) {
				maxPeople = currentPeople;
			}
		}

		System.out.println(maxPeople);
	}
}