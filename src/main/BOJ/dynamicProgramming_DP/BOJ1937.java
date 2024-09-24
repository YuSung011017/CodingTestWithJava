import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1937 {
    static int [][] table;
    static int [][] dp;
    static int n;
    static int [] dy = {1,-1,0,0};
    static int [] dx = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        table = new int [n][n];
        dp = new int [n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                recur(i,j);
            }
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max+1);

    }
    static int recur(int y, int x){

        if(dp[y][x] != 0){
            return dp[y][x];
        }

        for(int i = 0; i<4; i++){
            int ey = y + dy[i];
            int ex = x + dx[i];

            if(ey>=0 && ey<n && ex>=0 && ex<n){
                if(table[y][x]<table[ey][ex]){
                    dp[y][x] = Math.max(dp[y][x],recur(ey,ex)+1);
                }
            }
        }
        return dp[y][x];
    }
}
