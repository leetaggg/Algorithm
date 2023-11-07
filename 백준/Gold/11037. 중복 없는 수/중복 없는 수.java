import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = "";
		
		while((input = br.readLine()) != null) {
			int num = Integer.parseInt(input);
			while(true) {
				if(num >= 987654321) {
					sb.append(0).append("\n");
					break;
				}
				if(isCheck(++num)) {
					sb.append(num).append("\n");
					break;
				}
			}
			
		}// while 끝
		
		System.out.println(sb.toString());
		
	} //end main

	private static boolean isCheck(int n) {
		int num  = n;
		boolean[] visited = new boolean[10];
		//
		while(true) {
			if(num == 0) {
				break;
			}
			int temp = num % 10;
			if(temp == 0) {
				return false;
			}
			if(visited[temp]) {
				return false;
			}
			visited[temp] = true;
			num = num / 10;
		}
		
		return true;
	}
	
	

}//end class
