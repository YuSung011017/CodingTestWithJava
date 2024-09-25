import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int front = 0;
        int back = n-1;
        int count = 0;

        while(front<back){
            if(arr[front] + arr[back] == x){
                count++;
            }
            if(arr[front] + arr[back] >= x){
                back -= 1;
            }else{
                front += 1;
            }
        }

        System.out.println(count);

    }
}
