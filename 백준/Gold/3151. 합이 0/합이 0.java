import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedScanner bs = new BufferedScanner();

        n = bs.nextInt();

        arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = bs.nextInt();
        }

        Arrays.sort(arr);

        long result = 0;

        for (int i = 0; i < n; i++) {
            result += binarySearch(i);
        }


        System.out.println(result);

    }
    static int binarySearch(int pivot){

        int left = pivot + 1;
        int right = n - 1;

        int cnt = 0;

        while(left < right){

            int sum = arr[left] + arr[pivot] + arr[right];

            if(sum == 0){
                if(arr[left] == arr[right]){
                    cnt += right - left;
                    left++;
                }else{
                    int lcnt = 0, rcnt = 0;
                    int leftValue = arr[left];
                    int rightValue = arr[right];
                    while(leftValue == arr[left++]){
                        lcnt++;
                        if(leftValue != arr[left])break;
                    }
                    while(rightValue == arr[right--]){
                        rcnt++;
                        if(rightValue != arr[right]) break;
                    }
                    cnt += lcnt * rcnt;
                }

            }else if(sum < 0){
                left++;
            }else{
                right--;
            }
        }
        return cnt;
    }
    static class BufferedScanner {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public BufferedScanner() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public BufferedScanner(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}