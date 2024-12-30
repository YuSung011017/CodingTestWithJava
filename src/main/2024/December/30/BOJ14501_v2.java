import java.io.*;
import java.util.*;

public class BOJ14501_v2 {
    static int N;
    static int [][] arr;
    static int [] dp;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        dp = new int[N];

        for(int i = 0; i<N; i++){
            dp[i] = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        recur(0);

        int answer = 0;
        for(int i = 0; i<N; i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);


    }
    static int recur(int idx){
        if(idx == N) return 0;
        if(idx > N) return Integer.MIN_VALUE;
        if(dp[idx] != Integer.MIN_VALUE) return dp[idx];

        dp[idx] = Math.max(recur(idx+1),recur(idx+arr[idx][0])+arr[idx][1]);

        return dp[idx];
    }
}
