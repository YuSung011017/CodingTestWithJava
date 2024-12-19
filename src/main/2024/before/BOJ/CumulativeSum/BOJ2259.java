import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2259 {
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int prefix[] = new int[n+1];
        for(int i = 0;i<n; i++){
            prefix[i+1] = arr[i] + prefix[i];
        }
        ArrayList<Integer>answer = new ArrayList<>();
        for(int i = k; i<=n; i++){
            answer.add(prefix[i]-prefix[i-k]);
        }
        int max = answer.get(0);
        for(int i = 1; i< answer.size(); i++){
            max = Math.max(max,answer.get(i));
        }
        System.out.println(max);
    }
}
