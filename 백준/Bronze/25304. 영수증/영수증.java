import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		int b = sc.nextInt();
		long c = 0;
		for(int i = 1; i <= b; i++) {
			long d = sc.nextLong();
			int e = sc.nextInt();
			c = d * e + c;
		}
		sc.close();
		if(a == c) {
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
}