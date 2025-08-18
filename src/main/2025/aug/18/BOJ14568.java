import java.util.*;
import java.io.*;

public class BOJ14568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int a = 1; a<n; a++){
            for(int b = 1; b<n; b++){
                for(int c = 1; c<n; c++){
                    if(a+b+c == n){
                        if(c >= b+2){
                            if(a%2 == 0){
                                answer++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
