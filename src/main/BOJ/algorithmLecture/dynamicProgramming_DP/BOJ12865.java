import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {
    static int N,K;
    static int [][] dp;
    static int [][] products;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        products = new int [N][2];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            products[i][0] = Integer.parseInt(st.nextToken());
            products[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][100010];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j < 100010; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(sol(0,0));
    }
    static int sol(int idx, int weight){
        if(weight>K){
            return Integer.MIN_VALUE;
        }
        if(idx == N){
            return 0;
        }
        if(dp[idx][weight] != -1){
            return dp[idx][weight];
        }
        dp[idx][weight] = Math.max(sol(idx+1,weight),sol(idx+1,weight+products[idx][0])+products[idx][1]);
        return dp[idx][weight];
    }
}
