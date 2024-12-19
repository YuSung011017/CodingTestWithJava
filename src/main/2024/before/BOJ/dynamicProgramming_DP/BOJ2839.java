import java.io.*;

public class BOJ2839 {
    static int n;
    static int min;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        dp = new int[n+1]; // dp[7]은  무게가 7이 될때까지의 횟수의 최솟값이 들어갈 예정이다
        for (int i = 0; i <= n; i++) {
            dp[i] = 5001;
        }
        int ans = sol(n);
        if(ans >= 5001){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }

    }
    static int sol(int weight){
        if(weight == 0){
            return 0;
        }
        if(weight < 0){
            return 5001;
        }

        if(dp[weight] != 5001){
            return dp[weight];
        }
        dp[weight] = Math.min(sol(weight-5) + 1, sol(weight - 3) + 1);
        return dp[weight];
    }


}



