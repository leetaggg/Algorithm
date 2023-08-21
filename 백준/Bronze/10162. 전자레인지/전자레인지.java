import java.io.BufferedReader;//버퍼리더선언
import java.io.IOException;//임포트선언
import java.io.InputStreamReader;//임포트선언

public class Main {//클래스명

	public static void main(String[] args) throws NumberFormatException, IOException {//메인함수시작
		//버튼 a,b,c - 300초, 60초, 10초
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//버퍼리더
		int T = Integer.parseInt(br.readLine()); // 요리시간 입력 받음
		
		int[] button = {300, 60, 10}; //버튼 3개 300초 60초 10초
		
		for(int i = T/button[0]; i >= 0; i--) { //첫번째 버튼으로 셀수 있는 수만큼
			int time = T-(button[0]*i);// 남은 시간
			for(int j = time/button[1]; j >= 0; j--) { //두번째 버튼으로 셀수 있는 수만큼
				time = T-(button[1]*j);// 남은 시간
				if(time % button[2] == 0) {//세번째 나머지 값도 떨어지면
					int k = time / button[2]; //마지막 알람시계 누르는 횟수
					System.out.println(i+" "+ j +" "+k);//출력
					return;//된다면 리턴
				}
			}
		}
		System.out.println(-1);//안된다면 -1출력
		
	}

}
