import java.io.*; // io 라이브러리 import

public class Main { // class 시작
	public static void main(String[] args) throws IOException{ // main 클래스 시작, IOException 던짐
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받는 bufferedReader 생성
		int t = Integer.parseInt(br.readLine()); // 입력 받은 t int형으로 변환
		int btnA = 0; // A버튼 누른 횟수
		int btnB = 0; // B버튼 누른 횟수
		int btnC = 0; // C버튼 누른 횟수
		btnA = t / 300; // t를 A버튼(5분 * 60초)로 나눈 몫을 btnA에 저장
		t = t % 300; // t를 A버튼(5분 * 60초)로 나눈 나머지로 저장
		
		btnB = t / 60;// t를 B버튼(1분 * 60초)로 나눈 몫을 btnB에 저장
		t = t % 60;// t를 B버튼(1분 * 60초)로 나눈 나머지로 저장
		
		btnC = t / 10; // t를 C버튼(10초)로 나눈 몫을 btnC에 저장
		t = t % 10; // t를 C버튼(10초)로 나눈 나머지로 저장
		if(t == 0) { // 마지막 t 값이 0이면
			System.out.println(btnA + " " + btnB + " " + btnC); // 각 버튼을 누른 횟수를 출력
		} else { // t가 0이 아니라면
			System.out.println(-1); // -1로 출력
		}// if - else문 종료
	} // main 끝
} // class 끝
