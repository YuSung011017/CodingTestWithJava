import java.io.*;
import java.util.*;

public class BOJ10828 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack <Integer> stack = new Stack<>();
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp1 = st.nextToken();
            if(temp1.equals("push")){
                String temp2 = st.nextToken();
                stack.add(Integer.parseInt(temp2));
            }else if(temp1.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(stack.pop());
                }
            }else if(temp1.equals("size")){
                System.out.println(stack.size());
            }else if(temp1.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
            }else if(temp1.equals("top")){
                if(stack.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
