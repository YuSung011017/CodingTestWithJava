import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1090 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

       int [][]locations = new int [N][2];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            locations[i][0] = Integer.parseInt(st.nextToken());
            locations[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer[] = new int [N];
        for(int i = 0; i<N; i++){
            answer[i] = Integer.MAX_VALUE;
        }

        for(int []xloc : locations){
            for(int []yloc : locations){
                int [] dist = new int [N];
                for (int i = 0; i < locations.length; i++) {
                    dist[i] = Math.abs(xloc[0] - locations[i][0]) + Math.abs(yloc[1] - locations[i][1]);
                }
                Arrays.sort(dist);
                int cost = 0;
                for(int i = 0; i<N; i++){
                    cost += dist[i];
                    answer[i] = Math.min(cost,answer[i]);
                    // 해당 인덱스의 값(answer[i])와 현재 좌표의 거리(cost)와 비교하여 작은 값을 저장
                }
            }
        }
        for(int i = 0; i<N; i++){
            System.out.print(answer[i] + " ");
        }


    }
}
