import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line.trim());
			if (n == -1) {
				break;
			}

			int totalDistance = 0;
			int previousTime = 0;

			for (int i = 0; i < n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(br.readLine());
				int speed = Integer.parseInt(tokenizer.nextToken());
				int elapsedTime = Integer.parseInt(tokenizer.nextToken());

				int timeInterval = elapsedTime - previousTime;
				totalDistance += speed * timeInterval;

				previousTime = elapsedTime;
			}

			System.out.println(totalDistance + " miles");
		}
	}
}
