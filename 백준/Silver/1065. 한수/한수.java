import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(checkHansu(Integer.parseInt(br.readLine())));
	}

	static int checkHansu(int n){
		int cnt = 0;

		if(n < 100){
			return n;
		}else{
			cnt = 99;
			for (int i = 100; i <= n; i++) {
				int hun = i / 100;
				int ten = (i / 10) % 10;
				int one = i % 10;

				if((hun - ten) == (ten - one)){
					cnt++;
				}
			}
		}
		return cnt;
	}
}