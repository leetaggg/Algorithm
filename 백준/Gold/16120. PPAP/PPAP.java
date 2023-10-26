import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ppap = br.readLine().toCharArray();

        if(isPPAP(ppap)){
            System.out.println("PPAP");
        }else{
            System.out.println("NP");
        }
    }

    static boolean isPPAP(char[] ppap){

        if(ppap.length < 4){
            if(ppap.length == 1 && ppap[0] == 'P'){
                return true;
            }
            return false;
        }

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < 3; i++) {
            s.push(ppap[i]);
        }

        for (int i = 3; i < ppap.length; i++) {
            if(s.size() >= 3 && ppap[i] == 'P' && s.elementAt(s.size() - 1) == 'A' && s.elementAt(s.size() - 2) == 'P'&& s.elementAt(s.size() - 3) == 'P'){
                for (int j = 0; j < 3; j++) {
                    s.pop();
                }
            }
            s.push(ppap[i]);
        }

        if(s.size() == 1 && s.peek() == 'P'){
            return true;
        }else{
            return false;
        }
    }
}