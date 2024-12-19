import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        recur(0, "");
    }

    static void recur(int num, String output) {
        if (num == m) {
            System.out.println(output.trim()); // 출력 시 마지막 공백 제거
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!output.contains(String.valueOf(i))) { // 중복 체크
                recur(num + 1, output + i + " ");
            }
        }
    }
}
