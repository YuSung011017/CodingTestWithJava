import java.io.*;
import java.util.*;

public class BOJ14232 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(br.readLine());
        ArrayList<Long>answer = new ArrayList<>();
        for(long i = 2; i*i<=K; i++){
            while (K % i == 0) {
                answer.add(i);
                K /= i;
            }
        }
        if(K>1)
            answer.add(K);
        System.out.println(answer.size());
        for(int i = 0; i<answer.size(); i++){
            System.out.print(answer.get(i) + " ");
        }
    }
}
