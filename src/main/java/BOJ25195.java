import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ25195 {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] gomgom = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            gomgom[i][0] = Integer.parseInt(st.nextToken());
            gomgom[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int gomFanSize = Integer.parseInt(st.nextToken());
        int gomFan[] = new int[gomFanSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < gomFanSize; i++) {
            gomFan[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int i = 1; // 현재 노드 위치
        boolean flag = false;
        while (i != M) {
            stack.push(i);
            for (int j = 0; j < gomFanSize; j++) {
                if (i == gomFan[j] && !stack.isEmpty()) {
                    stack.pop();
                    continue;
                }
            }
            for (int j = 0; j < M; j++) {
                if (i == gomgom[j][0]) {
                    stack.push(gomgom[j][1]);
                }
            }
            int count = 0;
            for (int j = 0; j < M; j++) {
                if (i == gomgom[j][0]) {
                    count += 1;
                }
            }

            if (count > 0) {
                flag = true;
            }
            i = stack.peek();
        }

        if (flag) {
            System.out.println("yes");
        } else {
            System.out.println("Yes");
        }

    }
}

