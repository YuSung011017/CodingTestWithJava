import java.io.*;
import java.util.*;

public class test {
    static int n;
    static int[][] hint;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        hint = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            hint[i][0] = Integer.parseInt(st.nextToken()); // Number
            hint[i][1] = Integer.parseInt(st.nextToken()); // Strike
            hint[i][2] = Integer.parseInt(st.nextToken()); // Ball
        }

        answer = 0;
        recur(0, 100);
        System.out.println(answer);
    }

    static boolean checker(int idx, int number) {
        int _number = hint[idx][0];
        int _strike = hint[idx][1];
        int _ball = hint[idx][2];

        int strike = 0;
        int ball = 0;

        int _A = _number / 100;
        int _B = (_number % 100) / 10;
        int _C = _number % 10;

        int A = number / 100;
        int B = (number % 100) / 10;
        int C = number % 10;

        // Validation for digits
        if (A == 0 || B == 0 || C == 0) return false;
        if (A == B || A == C || B == C) return false;

        // Check strike
        if (A == _A) strike++;
        if (B == _B) strike++;
        if (C == _C) strike++;

        // Check ball
        if (A == _B || A == _C) ball++;
        if (B == _A || B == _C) ball++;
        if (C == _A || C == _B) ball++;

        return strike == _strike && ball == _ball;
    }

    static void recur(int idx, int number) {
        if (idx == n) {
            answer++;
            recur(0, number + 1);
            return;
        }

        if (number == 1000) return;

        if (checker(idx, number)) {
            recur(idx + 1, number);
        } else {
            recur(0, number + 1);
        }
    }
}
