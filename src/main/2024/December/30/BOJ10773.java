import java.io.*;
import java.util.*;

public class BOJ10773 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer>stack = new Stack<>();
        for(int i = 0; i<K; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                stack.pop();
            }else{
                stack.add(temp);
            }
        }
        int answer = 0;
        int size = stack.size();
        for(int i = 0; i<size; i++){
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
