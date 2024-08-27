import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr [] = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int [] prefix = new int [N+1];
        for(int i = 0; i<N; i++){
            prefix[i] = -1001;
        }
        for(int i = 0; i<N; i++){
            prefix[i+1] = Math.max(prefix[i] + arr[i],arr[i]);
        }
        int max = prefix[0];
        for(int i = 1; i<= N; i++){
            max = Math.max(max,prefix[i]);
        }
        System.out.println(max);

    }
}