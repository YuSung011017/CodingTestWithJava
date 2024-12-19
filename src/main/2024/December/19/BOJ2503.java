import java.io.*;
import java.util.*;

public class BOJ2503 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int [][] hint = new int [N][5];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int thint = Integer.parseInt(st.nextToken());
            hint[i][0] = thint/100;
            hint[i][1] = (thint - (hint[i][0] * 100))/10;
            hint[i][2] = (thint - (hint[i][0] * 100 + hint[i][1] * 10));
            hint[i][3] = Integer.parseInt(st.nextToken());
            hint[i][4] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for(int i = 134; i<=999; i++){
            int [] tryA = new int[3];
            tryA[0] = i/100;
            tryA[1] = (i-(tryA[0]*100))/10;
            tryA[2] = (i-(tryA[0]*100 + tryA[1]*10));
            if(tryA[0] == tryA[1] || tryA[0] == tryA[2] || tryA[1] == tryA[2]) continue;
            if(tryA[1] == 0 || tryA[2] == 0) continue;
            for(int j = 0; j<N; j++){
                int strike = 0;
                int ball = 0;
                if(tryA[0] == hint[j][0]){ // 100의 자리 검사
                    strike++;
                }else if(tryA[0] == hint[j][1] || tryA[0] == hint[j][2]){
                    ball++;
                }
                if(tryA[1] == hint[j][1]){ // 10의 자리 검사
                    strike++;
                }else if(tryA[1] == hint[j][0] || tryA[1] == hint[j][2]){
                    ball++;
                }
                if(tryA[2] == hint[j][2]){ // 1의 자리 검사
                    strike++;
                }else if(tryA[2] == hint[j][0] || tryA[2] == hint[j][1]){
                    ball++;
                }
                if(strike != hint[j][3] || ball != hint[j][4]) { // 스트라이크와 볼 갯수 중 하나라도 맞지 않는다면 반복문 종료
                    break;
                }
                if(j==N-1){ //모든 힌트를 통과하면 answer++
                    answer++;
                }

            }
        }

        System.out.println(answer);
    }
}
