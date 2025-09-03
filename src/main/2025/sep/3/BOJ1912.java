import java.io.*;
import java.util.*;

public class BOJ1912 {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int [n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        int sum = arr[0];
        for(int i = 1; i<n; i++){
            if(sum+arr[i]>arr[i]){
                sum += arr[i];
            }else{
                sum = arr[i];
            }
            max = Math.max(sum,max);
        }
        System.out.println(max);
    }
}
