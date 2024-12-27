import java.io.*;
import java.util.*;

public class BOJ11653 {
    public static void main(String[] args)throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N != 1){
            if(isPrime(N)){
                System.out.println(N);
            }else{
                for(int i = 2; i<=N; i++){
                    if(N%i == 0){
                        System.out.println(i);
                        N = (int)(N / i);
                        i=1;
                    }
                }
            }
        }

    }
    public static boolean isPrime(int n){
        int count = 0;
        for(int i = 2; i<=(int)Math.sqrt(n); i++){
            if(n%i == 0){
                count++;
                break;
            }
        }
        if(count==0){
            return true;
        }else{
            return false;
        }
    }
}
