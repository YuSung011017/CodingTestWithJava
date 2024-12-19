import java.io.*;

public class BOJ1816 {
    public static void main(String[] args) throws IOException {
       BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       long [] arr = new long[n];
       for(int i = 0; i<n; i++){
           arr[i] = Long.parseLong(br.readLine());
       }
       for(int i = 0; i<n; i++){
           int count = 0;
           for(long j = 2; j<= 1000000; j++){
              if(arr[i] % j == 0) {
                  count++;
                  break;
              }

           }
           if(count == 0){
               System.out.println("YES");
           }else{
               System.out.println("NO");
           }
       }
    }
}
