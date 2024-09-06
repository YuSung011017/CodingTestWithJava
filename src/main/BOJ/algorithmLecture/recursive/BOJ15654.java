import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
    static int [] arr;
    static int n,m;
    static ArrayList<Integer>answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
        }
        Arrays.sort(arr);
        answer = new ArrayList<>();
        recur(0);
    }
    static void recur(int num){
        if (num == m) {
            // 출력 형식 수정: ArrayList의 요소를 공백으로 구분하여 출력
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i));
                if (i < answer.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();  // 수열이 끝나면 줄 바꿈
            return;
        }
        for(int i = 0; i < n; i++){
            if(!answer.contains(arr[i])){
                answer.add(arr[i]);
                recur(num+1);
                answer.remove(answer.size() - 1);
            }
        }
    }
}
