package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16132 {
    static int n;
    static int[][] dp;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];

        for (int i = 0; i <= n; i++) { //0으로 초기화 하고 좋다
            for (int j = 0; j < 2; j++) {
                dp[i][j] = 0;
            }
        }
        sol(0);
        System.out.println(count);
    }

    static int sol(int idx) {
        if (idx > n) {
            return Integer.MIN_VALUE;
        }
        if (idx == n) {
            if (dp[idx][0] == dp[idx][1]) {
                count++;
            }
            return 0;
        }
        //최솟값이 아니라 같은 값이라 빡시네
        if (dp[idx][0] + idx > dp[idx][1] + idx) {
            dp[idx][1] += idx;
        } else if (dp[idx][0] + idx < dp[idx][1] + idx) {
            dp[idx][0] += idx;
        }
        return 0;
    }
}
