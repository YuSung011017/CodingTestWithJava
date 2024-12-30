import java.io.*;
import java.util.*;

public class BOJ12865 {
    static int N;
    static int K;
    static int [][] product;
    static int [][] dp;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N][100001];
        product = new int[N][2];

        for(int i = 0; i<N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i<N; i++){
        st = new StringTokenizer(br.readLine());
        product[i][0] = Integer.parseInt(st.nextToken());
        product[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recur(0,0));
    }
    static int recur(int idx, int weight){
        if(weight>K) return Integer.MIN_VALUE;
        if(idx == N) return 0;
        if(dp[idx][weight] != -1 ) return dp[idx][weight];

        dp[idx][weight] = Math.max(recur(idx+1,weight),
                recur(idx+1,weight+product[idx][0])+product[idx][1]);

        return dp[idx][weight];
    }
}
