import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class test {

    static int[] dp;
    static int N;
    static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        table = new int[N + 1][2];
        dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            table[i][0] = a;
            table[i][1] = b;
        }

        int ans = sol(1);
        System.out.println(ans);
    }

    static int sol(int idx) {
        if (idx > N + 1) { // 퇴사일 이후라 상담을 못해줌
            return Integer.MIN_VALUE;
        }

        if (idx == N + 1) { //퇴사날이라 상담을 못해줌
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        dp[idx] = Math.max(sol(idx + 1), sol(idx + table[idx][0]) + table[idx][1]);
        return dp[idx];
    }
}
