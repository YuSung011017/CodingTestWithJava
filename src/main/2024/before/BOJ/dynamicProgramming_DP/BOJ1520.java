import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {
    static int X,Y;
    static int [][] table;
    static int [][] dp;
    static int [] dy = {1,-1,0,0};
    static int [] dx = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        table = new int[Y][X];
        dp = new int[Y][X];
        for(int i = 0; i<Y; i++){
            for(int j = 0; j<X; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i<Y; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<X; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = recur(0,0);
        System.out.println(answer);

    }

    static int recur(int y, int x){
        if(y == Y-1 && x == X-1){
            return 1;
        }
        if(dp[y][x] != -1){
            return dp[y][x];
        }
        int route = 0;
        for(int i = 0; i<4; i++){
            int ey = y + dy[i];
            int ex = x + dx[i];

            if(ey>=0 && ey<Y && ex>=0 && ex<X){
                if(table[y][x]>table[ey][ex]){
                    route += recur(ey,ex);
                }
            }
        }
        dp[y][x] = route;
        return dp[y][x];
    }
}
