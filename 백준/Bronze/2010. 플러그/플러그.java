import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int totalPlugs = 0;

		for (int i = 0; i < N; i++) {
			int plugs = Integer.parseInt(br.readLine());
			totalPlugs += plugs;
		}

		int maxComputers = totalPlugs - (N - 1);
		System.out.println(maxComputers);
	}
}