import java.io.*;
import java.util.*;

public class BOJ2503 {
    static int N;
    static int [][] hint;
    static int hintNumber[][];
    static int answer;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hint = new int [N][2];
        hintNumber = new int [N][3];
        for(int i = 0 ;i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            hintNumber[i][0] = temp/100;
            hintNumber[i][1] = (temp -  hintNumber[i][0]*100)/10;
            hintNumber[i][2] = temp%10;
            hint[i][0] = Integer.parseInt(st.nextToken());
            hint[i][1] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        recur(100,0);
        System.out.println(answer);
    }
    static void recur(int number , int hintNum){
        if(number>999){
            return;
        }
        if(hintNum == N){
            answer++;
            recur(number+1,0);
            return;
        }

        int [] testNumber = new int [3];
        testNumber[0] = number/100;
        testNumber[1] = (number - testNumber[0]*100)/10;
        testNumber[2] = number % 10;

        if(testNumber[0]==0 || testNumber[1]==0 || testNumber[2]==0) {
            recur(number + 1, 0);
            return;
        }
        if(testNumber[0]==testNumber[1] || testNumber[1]==testNumber[2] || testNumber[2]==testNumber[0]) {
            recur(number + 1, 0);
            return;
        }

        int s = 0;
        int b = 0;

        if(testNumber[0] == hintNumber[hintNum][0]) s++;
        if(testNumber[1] == hintNumber[hintNum][1]) s++;
        if(testNumber[2] == hintNumber[hintNum][2]) s++;

        if(testNumber[0] == hintNumber[hintNum][1] || testNumber[0] == hintNumber[hintNum][2]) b++;
        if(testNumber[1] == hintNumber[hintNum][0] || testNumber[1] == hintNumber[hintNum][2]) b++;
        if(testNumber[2] == hintNumber[hintNum][1] || testNumber[2] == hintNumber[hintNum][0]) b++;

        if(s==hint[hintNum][0] && b==hint[hintNum][1]){
            recur(number,hintNum+1);
        }else{
            recur(number+1,0);
        }
    }
}
