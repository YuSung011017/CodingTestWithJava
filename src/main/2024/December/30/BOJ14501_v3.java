import java.io.*;
import java.util.*;

public class BOJ14501_v3 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [][] day = new int[N][2];
        int [] dp = new int [N+1];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            day[i][0] = Integer.parseInt(st.nextToken());
            day[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int idx = N-1; idx>=0; idx--){
            if(idx + day[idx][0] > N){
                dp[idx] = dp[idx+1];
            }else{
                dp[idx] = Math.max(dp[idx +1], dp[idx+day[idx][0]] + day[idx][1]);
            }
        }

        System.out.println(dp[0]);

    }
}
