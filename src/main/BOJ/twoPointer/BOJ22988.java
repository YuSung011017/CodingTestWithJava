import java.util.*;
import java.io.*;

public class BOJ22988 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n;
        long x;
        n = Integer.parseInt(st.nextToken());
        x = Long.parseLong(st.nextToken());

        long [] arr = new long [n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int front = 0;
        int back = n-1;
        int count = 0;
        int remain = 0;

        while(front <= back){
            if(arr[back] == x){
                count += 1;
                back -= 1;
                continue;
            }

            if(front == back){
                remain += 1;
                break;
            }

            if(arr[front] + arr[back] >= x/2.0){
                count += 1;
                front += 1;
                back -= 1;
            }else{
                front += 1;
                remain += 1;
            }
        }
        System.out.println(count + remain / 3);

    }
}
