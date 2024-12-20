import java.io.*;
import java.util.*;

public class BOJ1978 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int temp = Integer.parseInt(st.nextToken());
            int testCount = 0;
            if(temp != 1) {
                for (int j = 2; j <= (int) Math.sqrt(temp); j++) {
                    if (temp % j == 0) {
                        testCount += 1;
                        break;
                    }
                }
                if (testCount == 0) {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
