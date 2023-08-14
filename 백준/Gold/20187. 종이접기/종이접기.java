import java.io.*;

public class Main {
    static int K, H;
    static int[][] m;
    static char[] crr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(br.readLine()); // 손수건의 크기 K 1~8, 가로의 크기 2^K, 전체 맵의 크기 2^K * 2^K
        m = new int[1 << K][1 << K];
        crr = new char[2 * K];
        String line = br.readLine(); // 2K개 접기 명령
        for (int i = 0, index = 0; i < crr.length; i++, index += 2) {
            crr[i] = line.charAt(index);
        }

        H = Integer.parseInt(br.readLine()); // 구멍 뚫는 위치, 0 ~ 3
        go(0, 0, 0, 1 <<K, 1 << K);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                sb.append(m[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    /**
     * step : 0~2K, 시작 좌표 r, c, 높이 폭 h, w
     */
    static int[] vertical = {2, 3, 0, 1}; // 수직 (상하 작업 시)
    static int[] horizontal = {1, 0, 3, 2}; // 수평 (좌우 작업 시)

    public static void go(int step, int r, int c, int h, int w) {
        if (step == 2 * K) { // 1 x 1 칸이면
            m[r][c] = H;
            return;
        }
//        D, U, R, L
//        재귀 호출
//        내 쪽으로 대칭시켜서 저장 r, c ~ h, w
        if (crr[step] == 'D') { // 위를 아래로 접음, 아래가 원본, 위로 복사하기
            go(step + 1, r + h / 2, c, h / 2, w);
            for (int i = 0; i < h / 2; i++) {
                for (int j = 0; j < w; j++) {
                    m[r + i][c + j] = vertical[m[r + h - 1 - i][c + j]];
                }
            }
        } else if (crr[step] == 'U') { // 아래를 위로 접음, 위가 원본, 아래로 복사
            go(step + 1, r, c, h / 2, w);
            for (int i = 0; i < h / 2; i++) {
                for (int j = 0; j < w; j++) {
                    m[r + h - 1 - i][c + j] = vertical[m[r + i][c + j]];
                }
            }
        } else if (crr[step] == 'R') { // 좌를 우로 접음, 우가 원본, 좌로 복사
            go(step + 1, r, c + w / 2, h, w / 2);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w / 2; j++) {
                    m[r + i][c + j] = horizontal[m[r + i][c + w - 1 - j]];
                }
            }
        } else if (crr[step] == 'L') { // 우를 좌로 접음, 좌가 원본, 우로 복사
            go(step + 1, r, c, h / 2, w);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w / 2; j++) {
                    m[r + i][c + w - 1 - j] = m[r + i][c + j];
                }
            }
        }
    }
}