import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15652 {
    //1부터 N까지 자연수 중에서 M개를 고른 수열
    //같은 수를 여러 번 골라도 된다.
    //고른 수열은 비내림차순이어야 한다.
    //길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
    static ArrayList<Integer>arr;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        recur(0 ,1);
    }

    static void recur(int num, int start) {
        if (num == m) {
            // 출력 형식 수정: ArrayList의 요소를 공백으로 구분하여 출력
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i));
                if (i < arr.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();  // 수열이 끝나면 줄 바꿈
            return;
        }
        for (int i = start; i <= n; i++) {
            arr.add(i);
            recur(num + 1,i);
            arr.remove(arr.size() - 1);
        }
    }

}
