import java.io.*;
import java.util.*;

public class BOJ1920 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> arrN = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arrN.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        int [] arrM = new int [M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            arrM[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i<arrM.length; i++){
            if(arrN.contains(arrM[i])){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }



    }
}
