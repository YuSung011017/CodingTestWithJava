import java.io.*;
import java.util.*;

public class BOJ15651 {
    static int N;
    static int M;
    static List<Integer> arr;
    static BufferedWriter bw;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        recur(0);
        bw.flush();
    }

    public static void recur(int number)throws IOException  {
        if(number == M){
            for(int num : arr){
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = 1; i<=N; i++){
            arr.add(i);
            recur(number+1);
            arr.remove(arr.size()-1);
        }

    }
}
