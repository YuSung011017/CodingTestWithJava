import java.io.*;
import java.util.*;

public class BOJ2559 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];
        int [] prefix = new int [N+1];
        int answer = Integer.MIN_VALUE;

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<N; i++){
            prefix[i+1] = arr[i] + prefix[i];
        }
        for(int i = K; i<=N; i++){
            answer = Math.max(prefix[i]-prefix[i-K],answer);
        }
        System.out.println(answer);
    }
}
