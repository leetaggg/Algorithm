import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			String s = String.valueOf(n);
			int sum = 0;
			for(int i = s.length(); i > 0; i--) {
				int num = Character.getNumericValue(s.charAt(s.length() - i));
				int fat = 1;
				for(int j = 1; j <= i; j++) {
					fat *= j;
				}
				sum = sum + (num * fat);
			}
			System.out.println(sum);
		}
	}
}
