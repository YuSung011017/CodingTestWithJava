import java.io.*;
import java.util.*;

public class BOJ1407 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int [] answerCount = new int [(int)(B-A)+1];
        for(int i = 0; i<=(int)(B-A); i++){
            answerCount[i] = 0;
        }
        for(long i = A; i<=B; i++){
            long num = i;
            int count = 0;
            while(num % 2 == 0) {
                count++;
                num /= 2;
            }

            answerCount[(int)(i-A)] = count;
        }
        int answer = 0;
        for(int i = 0; i<answerCount.length; i++){
            if(answerCount[i] == 0){
                answer += 1;
            }else{
                int temp = 1;
                for(int j = 0; j<answerCount[i]; j++){
                    temp *= 2;
                }
                answer += temp;
            }
        }
        System.out.println(answer);
    }
}
