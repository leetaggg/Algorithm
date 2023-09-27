import java.io.*;
import java.util.*;

public class Main {
    static int[][] sudoku;
    static List<Integer> list;
    static boolean flag;

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];
        list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = line[j] - '0';
                if(sudoku[i][j] == 0){
                    list.add(i * 9 + j);
                }
            }
        }

        solve(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void solve(int depth){
        if(depth == list.size()){
            flag = true;
            return;
        }

        int pos = list.get(depth);
        int r = pos / 9;
        int c = pos % 9;

        for (int i = 1; i <= 9; i++) {
            sudoku[r][c] = i;
            if(isSudoku(r, c)){
                solve(depth + 1);
                if(flag) return;
            }
        }
        sudoku[r][c] = 0;

    }

    public static boolean isSudoku(int r, int c){
        for (int i = 0; i < 9; i++) {
            if(i != c && sudoku[r][c] == sudoku[r][i]) return false;
            if(i != r && sudoku[r][c] == sudoku[i][c]) return false;
        }

        int nr = (r / 3) * 3;
        int nc = (c / 3) * 3;

        for (int i = nr; i < nr + 3; i++) {
            for (int j = nc; j < nc + 3; j++) {
                if(i != r && j != c && sudoku[r][c] == sudoku[i][j]) return false;
            }
        }

        return true;
    }
}
