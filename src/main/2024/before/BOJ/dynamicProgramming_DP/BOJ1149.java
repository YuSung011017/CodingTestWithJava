import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] table  = new int [n][3];
        int [][] dp = new int [2][3];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
            table[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<3; i++){ //첫번째 집(0번째 인덱스) 초기화
            dp[0][i] = table[0][i];
        }

        for (int i = 1; i<n; i++){
            //현재 집을 빨강으로 선택시
            dp[1][0] = Math.min(table[i][0] + dp[0][1],table[i][0] + dp[0][2]);
            //현재 집을 초록으로 선택시
            dp[1][1] = Math.min(table[i][1] + dp[0][0],table[i][1] + dp[0][2]);
            //현재 집을 파랑으로 선택시
            dp[1][2] = Math.min(table[i][2] + dp[0][0],table[i][2] + dp[0][1]);

            for(int j = 0; j<3; j++){
                dp[0][j] = dp[1][j]; //dp 테이블 갱신
            }
        }

        int answer = Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
        System.out.println(answer);
    }
}
