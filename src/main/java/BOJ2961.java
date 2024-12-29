import java.io.*;
import java.util.*;

public class BOJ2961 {
    static int N;
    static int [][] ingre;
    static int answer;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ingre = new int[N][2];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingre[i][0] = Integer.parseInt(st.nextToken());
            ingre[i][1] = Integer.parseInt(st.nextToken());
        }
        answer = Integer.MAX_VALUE;
        recur(0,0,1,0);
        System.out.println(answer);
    }

    static void recur(int time, int number, int sour, int bitter){

        if(number == N){
            if(time>0){
                answer = Math.min(answer,Math.abs(sour - bitter));
            }
            return;
        }
        recur(time,number+1,sour,bitter);
        recur(time+1,number+1, sour*ingre[number][0], bitter+ingre[number][1]);
    }
}
