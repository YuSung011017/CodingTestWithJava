import java.io.*;
import java.util.*;

public class BOJ1090 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int [N][2];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 문제의 핵심은 완전탐색의 범위를 줄이는 것 -> 원래는 엄청 큰 체스판을 하나씩 다 봐야했음
        // But x,y가 겹치는 부분만 체크하면 끝
        int [] answer = new int [N];
        for(int i = 0; i<N; i++){
            answer[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                int [] dist = new int [N];
                for(int k = 0; k<N; k++){
                    dist[k] = Math.abs(arr[i][0]-arr[k][0]) + Math.abs(arr[j][1] - arr[k][1]);
                }
                Arrays.sort(dist);
                int cost = 0;
                for(int p = 0; p<N; p++){
                    cost += dist[p];
                    answer[p] = Math.min(answer[p],cost);
                }
            }
        }
        for(int i = 0; i<N; i++){
            System.out.print(answer[i] + " ");
        }




    }
}
