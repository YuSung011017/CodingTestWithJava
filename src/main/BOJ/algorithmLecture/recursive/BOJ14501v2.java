import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501v2 {
    //탑다운DP를 활용한 풀이방법
    static int n;
    static int [] dp;
    static int [][] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        table = new int[n+1][2];
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int [n+1];
        for(int i = 1; i<=n; i++){
            dp[i] = -1;
        }
        System.out.println(sol(1));
    }
    static int sol(int num){
        if(num>n+1){ //퇴사날이 지났다면 MIN_VALUE 반환
            return Integer.MIN_VALUE;
        }
        if(num == n+1){ //퇴사날이라면 0반환
            return 0;
        }
        if(dp[num] != -1) //이미 dp에 값이 들어가있다면 다시 계산하는 것을 막기위한 조건문
            return dp[num];

        dp[num] = Math.max(sol(num+1),sol(num+table[num][0])+table[num][1]);
        return dp[num];
    }
}
