import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int n, m;
    static StringBuilder sb = new StringBuilder(); // StringBuilder를 사용하여 출력 모으기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        recur(0, "");
        System.out.print(sb.toString()); // 한 번에 출력
    }

    static void recur(int num, String output) {
        if (num == m) {
            sb.append(output).append("\n"); // StringBuilder에 결과 추가
            return;
        }
        for (int i = 1; i <= n; i++) {
            recur(num + 1, output + i + " ");
        }
    }
}
