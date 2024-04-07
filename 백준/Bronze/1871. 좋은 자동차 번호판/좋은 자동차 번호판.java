import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++){
			String input = br.readLine();
			String a = input.split("-")[0];
			String b = input.split("-")[1];
			int valueA = 0;
			for(int j = 0; j < a.length(); j++){
				int value = a.charAt(j) - 'A';
				value *= Math.pow(26, 2 - j);
				valueA += value;
			}
			int valueB = Integer.parseInt(b);
			if(Math.abs(valueA - valueB) <= 100) sb.append("nice\n");
			else sb.append("not nice\n");
		}

		System.out.println(sb);
	}
}