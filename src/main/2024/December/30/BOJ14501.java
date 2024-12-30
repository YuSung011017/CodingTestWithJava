import java.io.*;
import java.util.*;

public class BOJ14501 {
    static int N;
    static int [][] arr;
    static int cost;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        cost = 0;
        recur(0,0);
        System.out.println(cost);
    }
    static void recur(int day, int money){
        if(day == N){
            cost = Math.max(cost,money);
            return;
        }
        if(day > N){
            money = Integer.MIN_VALUE;
            return;
        }
        recur(day + arr[day][0],money+arr[day][1]);
        recur(day+1,money);
    }
}
