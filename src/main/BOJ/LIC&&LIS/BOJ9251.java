import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String m = br.readLine();
        String n = br.readLine();

        char [] mArr = m.toCharArray();
        char [] nArr = n.toCharArray();

        int [][] dp = new int [mArr.length+1][nArr.length+1];

        for(int i = 1; i <= mArr.length; i++){
            for(int j = 1; j<= nArr.length; j++){
                if(mArr[i-1] == nArr[j-1]){ //같은 문자가 나온다면
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[mArr.length][nArr.length]);

    }
}
