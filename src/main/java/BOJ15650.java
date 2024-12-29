import java.io.*;
import java.util.*;

public class BOJ15650 {
    static int N;
    static int M;
    static List<Integer> arr;
    static boolean [] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        visited = new boolean [N+1];
        recur(0);
    }

    public static void recur(int number){
        if(number == M){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
        }
        for(int i = 1; i<=N; i++){
            if(visited[i]) continue;
            if(!arr.isEmpty()){
                if(arr.get(arr.size()-1)>i) continue;
            }
            arr.add(i);
            visited[i] = true;
            recur(number+1);
            arr.remove(arr.size()-1);
            visited[i] = false;
        }

    }
}
