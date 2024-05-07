import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<String> absentees = new ArrayList<>();
		String previousName = null;

		for (int i = 0; i < N; i++) {
			String line = br.readLine().trim();

			if ("Present!".equals(line)) {
				previousName = null;
			} else {
				if (previousName != null) {
					absentees.add(previousName);
				}
				previousName = line;
			}
		}

		if (previousName != null) {
			absentees.add(previousName);
		}

		if (absentees.isEmpty()) {
			System.out.println("No Absences");
		} else {
			for (String name : absentees) {
				System.out.println(name);
			}
		}

		br.close();
	}
}