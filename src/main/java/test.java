import java.io.*;
import java.util.*;

public class test {
    static int N;
    static int protein, fat, carbo, vitamin;
    static int[][] ingredients;
    static int answer;
    static ArrayList<Integer> used, answerUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력받기
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        protein = Integer.parseInt(st.nextToken());
        fat = Integer.parseInt(st.nextToken());
        carbo = Integer.parseInt(st.nextToken());
        vitamin = Integer.parseInt(st.nextToken());

        ingredients = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ingredients[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기화
        answer = Integer.MAX_VALUE;
        used = new ArrayList<>();
        answerUsed = new ArrayList<>();

        // 재귀 호출 시작
        recur(0, 0, 0, 0, 0, 0);

        // 결과 출력
        if (!answerUsed.isEmpty()) {
            System.out.println(answer);
            for (int num : answerUsed) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    static void recur(int idx, int p, int f, int c, int v, int price) {
        if (p >= protein && f >= fat && c >= carbo && v >= vitamin) {
            if (price < answer) {
                answer = price;
                answerUsed = new ArrayList<>(used); // 현재 조합 저장
            }
        }

        if (idx == N) return; // 모든 재료를 다 탐색한 경우 종료

        // 현재 재료를 선택하는 경우
        used.add(idx + 1); // 재료 번호는 1부터 시작하므로 +1
        recur(idx + 1,
                p + ingredients[idx][0],
                f + ingredients[idx][1],
                c + ingredients[idx][2],
                v + ingredients[idx][3],
                price + ingredients[idx][4]);
        used.remove(used.size() - 1); // 백트래킹을 위해 제거

        // 현재 재료를 선택하지 않는 경우
        recur(idx + 1, p, f, c, v, price);
    }
}
