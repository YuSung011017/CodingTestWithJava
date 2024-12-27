import java.io.*;
import java.util.*;

public class BOJ9012 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            Stack<Character> stack = new Stack<>();
            String temp = br.readLine();
            for(int j = 0; j<temp.length(); j++){
                if(!stack.isEmpty() && stack.peek() == '('){
                    if(temp.charAt(j) == ')'){
                        stack.pop();
                    }else{
                        stack.add(temp.charAt(j));
                    }
                }else if(stack.isEmpty()){
                    stack.add(temp.charAt(j));
                }
            }
            if(stack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
