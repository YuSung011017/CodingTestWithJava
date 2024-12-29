import java.io.*;
import java.util.*;

public class BOJ11660 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] map = new int[N][N];
        int [][] answer = new int [M][4];
        int [][] prefix = new int [N+1][N+1];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<4; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                prefix[i+1][j+1] = prefix[i][j+1] + prefix[i+1][j] - prefix[i][j] + map[i][j];
            }
        }

        for(int i = 0; i<M; i++){
            int x1 = answer[i][0];
            int y1 = answer[i][1];
            int x2 = answer[i][2];
            int y2 = answer[i][3];
            int result = prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1];
            System.out.println(result);
        }


    }
}
