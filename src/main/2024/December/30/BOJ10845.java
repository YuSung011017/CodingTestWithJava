import java.io.*;
import java.util.*;

public class BOJ10845 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Queue<Integer>queue = new LinkedList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            int num = 0;
            if(temp.equals("push")){
                num = Integer.parseInt(st.nextToken());
                queue.add(num);
            }else if(temp.equals("pop")){
                if(queue.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(queue.poll());
                }
            }else if(temp.equals("size")){
                System.out.println(queue.size());
            }else if(temp.equals("empty")){
                if(queue.isEmpty()){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
            }else if(temp.equals("front")){
                if(queue.isEmpty()){
                    System.out.println("-1");
                }else{
                    System.out.println(queue.peek());
                }
            }else if(temp.equals("back")){
                if(queue.isEmpty()){
                    System.out.println("-1");
                }else{
                    int last = 0;
                    for(int number : queue){
                        last = number;
                    }
                    System.out.println(last);
                }
            }
        }
    }
}
