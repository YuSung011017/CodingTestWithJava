import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ19942 {
    static int N;
    static int[][] product;
    static int answer;
    static int[] standard;
    static ArrayList<Integer> arr, best;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        product = new int[N][5];
        standard = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            standard[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            product[i][0] = Integer.parseInt(st.nextToken()); // p, 단백질
            product[i][1] = Integer.parseInt(st.nextToken()); // f, 지방
            product[i][2] = Integer.parseInt(st.nextToken()); // s, 탄수화물
            product[i][3] = Integer.parseInt(st.nextToken()); // v, 비타민
            product[i][4] = Integer.parseInt(st.nextToken()); // c, 가격
        }
        answer = Integer.MAX_VALUE;
        arr = new ArrayList<>();
        best = new ArrayList<>();
        recur(0, 0, 0, 0, 0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1); // 조건을 만족하는 조합이 없는 경우
        } else {
            System.out.println(answer);
            String output = "";
            for (int i : best) {
                output += i + " ";
            }
            System.out.println(output.trim()); // 마지막 공백 제거
        }
    }

    static void recur(int num, int p, int f, int s, int v, int c) {
        if (num == N) {
            if (p >= standard[0] && f >= standard[1] && s >= standard[2] && v >= standard[3]) {
                if (c < answer || (c == answer && smaller())) {
                    answer = c;
                    best = new ArrayList<>(arr); // 최소 비용일 때만 best 리스트 업데이트
                }
            }
            return;
        }
        arr.add(num + 1);
        recur(num + 1, p + product[num][0], f + product[num][1], s + product[num][2], v + product[num][3], c + product[num][4]);
        arr.remove(arr.size() - 1);

        recur(num + 1, p, f, s, v, c);
    }

    // 현재 arr와 best를 사전순으로 비교
    static boolean smaller() {
        for (int i = 0; i < Math.min(arr.size(), best.size()); i++) {
            if (arr.get(i) < best.get(i)) {
                return true;
            } else if (arr.get(i) > best.get(i)) {
                return false;
            }
        }
        return arr.size() < best.size(); // 길이가 짧을수록 사전순으로 앞서 있음
    }
}
