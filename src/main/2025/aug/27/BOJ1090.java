import java.io.*;
import java.util.*;

public class BOJ1090 {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int [][] home = new int [n][2];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            home[i][0] = Integer.parseInt(st.nextToken());
            home[i][1] = Integer.parseInt(st.nextToken());
        }
        int [] answer = new int [n];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int [] dist = new int [n];
                for(int k = 0; k<n; k++){
                    dist[k] = Math.abs(home[i][0]-home[k][0]) + Math.abs(home[j][1]-home[k][1]);
                }
                Arrays.sort(dist);
                int cost = 0;
                for(int c = 0; c<n; c++){
                    cost += dist[c];
                    answer[c] = Math.min(answer[c],cost);
                }
            }
        }
        for(int i = 0; i<n; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
