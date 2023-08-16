import java.util.Scanner;

public class Main {
    static int N, answer;
    static int[] col;
    static boolean[] column, rup, lup;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        col = new int[N]; // 퀸을 배치할 열 값을 저장
        column = new boolean[N]; // 사용한 컬럼 인덱스를 저장할 플래그 배열
        rup = new boolean[N * 2]; // 사용한 우상 대각 인덱스를 저장할 플래그 배열, 2N - 1 안씀
        lup = new boolean[N * 2]; // 사용한 좌상 대각 인덱스를 저장할 플래그 배열, 0 안씀
        setQueens(0); // 0행부터 시도
        System.out.println(answer);
    }
    public static void setQueens(int rowNo){
        if(rowNo == N){ //
            answer++;
            return;
        }
        for(int j = 0; j < N; j++){
            if(column[j] || rup[rowNo + j] || lup[rowNo - j + N]) continue;  // 가능한 배치라면
            column[j] = true;
            rup[rowNo + j] = true;
            lup[rowNo - j + N] = true;
            setQueens(rowNo + 1);
            column[j] = false;
            rup[rowNo + j] = false;
            lup[rowNo - j + N] = false;
        }
    }
}