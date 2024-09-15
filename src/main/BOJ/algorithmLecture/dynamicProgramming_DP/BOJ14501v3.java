import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501v3 {
    //백준 14501 퇴사 문제 바텀업DP로 해결
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] table = new int[n][2];
        for(int i = 0; i<n; i++){
            StringTokenizer st  = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken()); //i번 째 날의 상담 중 일 수
            table[i][1] = Integer.parseInt(st.nextToken()); //i번 째 날의 상잠 중 금액
        }
        int dp[] = new int[n+1];
        for(int idx = n-1; idx>=0; idx--) {
            if (idx + table[idx][0] > n) {//퇴사날 이후라면
                dp[idx] = dp[idx+1];
            }else{
                dp[idx] = Math.max(dp[idx+1],dp[idx+table[idx][0]] + table[idx][1]);
            }
        }

        System.out.println(dp[0]);
    }
}
