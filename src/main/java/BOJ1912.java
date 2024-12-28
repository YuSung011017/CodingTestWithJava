import java.io.*;
import java.util.*;

public class BOJ1912 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];
        int [] prefix = new int[N+1];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = -1001;
        }
        for(int i=0; i<N; i++){
            prefix[i+1] = Math.max(prefix[i] + arr[i],arr[i]);
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i<=N; i++){
            answer = Math.max(answer,prefix[i]);
        }
        System.out.println(answer);

    }
}
