import java.io.*;
import java.util.*;

public class BOJ1015 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        N = Integer.parseInt(br.readLine());
        int [] A = new int [N];
        int [] B = new int [N];
        int [] answer = new int [N];
        boolean [] check = new boolean [N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
           int temp = Integer.parseInt(st.nextToken());
           A[i] = temp;
           B[i] = temp;
        }
        Arrays.sort(B);
        int k = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(A[i] == B[j] && check[j] == false){
                    answer[k] = j;
                    k++;
                    check[j] = true;
                    break;
                }
            }
        }

        for(int i = 0; i<N; i++){
            System.out.print(answer[i] + " ");
        }


    }
}
