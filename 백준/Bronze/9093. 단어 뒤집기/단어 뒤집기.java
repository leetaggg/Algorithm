import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받을 BufferedReader 객체 생성
		StringBuilder result = new StringBuilder(); // 뒤집은 문자열을 담아 조합하는 StringBuilder 생성
		
		int T = Integer.parseInt(br.readLine()); // 첫 줄 TestCase 갯수를 받을 변수
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); // TestCase 수 만큼 입력 받음
			 while(st.hasMoreTokens()) { // 문자열 토큰이 없을 때까지 실행 
					StringBuilder sb = new StringBuilder(st.nextToken()); // 토큰 하나로 StringBuilder 객체 생성
					result.append(sb.reverse() + " "); //뒤집은 문자열을 result 객체에 담고 띄어쓰기까지 담음
			 }
			 result.append("\n"); //한 줄을 모두 뒤집었으면 한 줄 띄우기
		}
		System.out.println(result); // 담은 뒤집은 문자열 출력

	}
}
