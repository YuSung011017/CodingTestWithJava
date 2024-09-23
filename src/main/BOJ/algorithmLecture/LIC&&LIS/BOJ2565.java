import java.util.*;
import java.io.*;

public class BOJ2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [][] table = new int[n][2];
        int [] dp = new int[n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        Arrays.sort(table, Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(table[i][1] > table[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(n-max);
    }
}
