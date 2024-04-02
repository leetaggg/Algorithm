import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String user = br.readLine();

		if(a.contains(user) && b.contains(user)){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}