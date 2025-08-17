import java.io.*;

public class BOJ1816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long [] keys = new long[n];
        for(int i = 0; i<n; i++) {
            keys[i] = Long.parseLong(br.readLine());
            for(long j = 2; j<=1000000; j++){
                if(keys[i] % j == 0){
                    System.out.println("NO");
                    break;
                }
                if(j==1000000){
                    System.out.println("YES");
                }

            }
        }

    }
}