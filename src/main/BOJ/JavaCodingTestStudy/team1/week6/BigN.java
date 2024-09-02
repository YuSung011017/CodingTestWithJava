import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BigN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        int [][]map = new int[N][N];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                pq.add(temp);
            }
        }
        for(int i=0; i<N; i++){
            if(i==N-1){
                System.out.println(pq.poll());
            }else{
                pq.poll();
            }
        }

    }
}
