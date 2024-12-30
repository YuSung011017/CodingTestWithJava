import java.io.*;
import java.util.*;

public class BOJ12865_v2 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [][] dp = new int[N+1][K+1];
        int [][] item = new int[N+1][2];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st.nextToken());
            item[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(item[i][0] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-item[i][0]] + item[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
