package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ21610 {
    static int[][] delta = new int[][]{
            {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}
    };
    static int M, N;
    static int[][] map;
    static int[][] move;
    static ArrayList<int[]> stormMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                move[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeStorm();
        for (int i = 0; i < 4; i++) {
            moveStorm(i);
            rain();
            //totalRain();
        }
    }

    public static void makeStorm() {
        stormMap.add(new int[]{N, 1});
        stormMap.add(new int[]{N, 2});
        stormMap.add(new int[]{N - 1, 1});
        stormMap.add(new int[]{N - 1, 2});
    }

    public static void moveStorm(int idx) {
        int[] temp;
        for (int j = 0; j < stormMap.size(); j++) {
            temp = stormMap.get(j);
            for (int i = 0; i < move[idx][1]; i++) {
                temp[0] = (temp[0] + delta[move[idx][0]][0]) % N;
                temp[1] = (temp[1] + delta[move[idx][0]][1]) % N;
            }
            stormMap.set(j, temp);
        }
    }

    public static void rain() {
        for (int i = 0; i < stormMap.size(); i++) {
            int[] temp;
            temp = stormMap.get(i);
            map[temp[0]][temp[1]] += 1;
        }
    }


}
