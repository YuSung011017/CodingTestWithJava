import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            if(i%2 == 0){
                if(a%2 == 0){
                    b = b + a/2;
                    a = a/2;
                }else{
                    b += (int)a/2 + 1;
                    a -= (int)a/2 + 1;
                }
            }else{
                if(b%2 == 0){
                    a = a + b/2;
                    b = b/2;
                }else{
                    a += (int)b/2 + 1;
                    b -= (int)b/2 + 1;
                }
            }
        }

        System.out.println(a + " " + b);
    }
}