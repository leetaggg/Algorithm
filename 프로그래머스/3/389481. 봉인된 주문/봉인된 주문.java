import java.util.*;
import java.io.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        
        long[] bansToNums = new long[bans.length];
        
        for (int i = 0; i < bans.length; i++) {
            bansToNums[i] = strToNum(bans[i]);
        }
        
        Arrays.sort(bansToNums);
        
        for (int i = 0; i < bansToNums.length; i++) {
            if (bansToNums[i] <= n) {
                n++;
            } else {
                break;
            }
        }
        
        return numToStr(n);
    }
    
    public Long strToNum(String word) {
        int length = word.length();
        long num = 0;
        for (int i = 0; i < length; i++) {
            num += ((word.charAt(i) - 96) * Math.pow(26, length - i - 1));
        }
        
        return num;
    }

    public String numToStr(long num) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            sb.append((char) (((num - 1) % 26) + 97));
            num = ((num - 1) / 26);
        }
        
        return sb.reverse().toString();
        
    }
}


/*
a = 1, b = 2, c = 3, d = 4, e = 5, f = 6, g = 7, h = 8, i = 9, j = 10, k = 11, l = 12, m = 13, n = 14, o = 15, p = 16, q = 17, r = 18, s = 19,
t = 20 u = 21, v = 22, w = 23, x = 24, y = 25, z = 26
aa = 27 ab ac ad ae af 
ba = 52
ca = 77
da = 102
ea = 


*/
