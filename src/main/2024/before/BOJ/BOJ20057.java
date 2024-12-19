import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20057 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        int i = N / 2;
        int j = N / 2;
        int move = 1;
        while (true) {
            //좌
            for (int k = 0; k < move; k++) {
                i = i - move;
                int lrud = (int) (map[i][j] * (0.01));
                if (i + 1 < 0 || i + 1 >= N || j + 1 < 0 || j + 1 >= N) {
                    result += lrud;
                } else {
                    map[i + 1][j + 1] += (int) (map[i][j] * (0.01));
                }
                if (i + 1 < 0 || i + 1 >= N || j - 1 < 0 || j - 1 >= N) {
                    result += lrud;
                } else {
                    map[i + 1][j - 1] += (int) (map[i][j] * (0.01));
                }

                int lud = (int) (map[i][j] * (0.07));
                if (i < 0 || i >= N || j + 1 < 0 || j + 1 >= N) {
                    result += lrud;
                } else {
                    map[i][j + 1] += (int) (map[i][j] * (0.07));
                }
                if (i < 0 || i >= N || j - 1 < 0 || j - 1 >= N) {
                    result += lrud;
                } else {
                    map[i][j - 1] += (int) (map[i][j] * (0.07));
                }

                int llud = (int) (map[i][j] * (0.1));
                if (i - 1 < 0 || i - 1 >= N || j + 1 < 0 || j + 1 >= N) {
                    result += llud;
                } else {
                    map[i - 1][j + 1] += (int) (map[i][j] * (0.1));
                }
                if (i - 1 < 0 || i - 1 >= N || j - 1 < 0 || j - 1 >= N) {
                    result += llud;
                } else {
                    map[i - 1][j - 1] += (int) (map[i][j] * (0.1));
                }

                int luudd = (int) (map[i][j] * (0.02));
                if (i < 0 || i >= N || j + 2 < 0 || j + 2 >= N) {
                    result += luudd;
                } else {
                    map[i][j + 2] += (int) (map[i][j] * (0.02));
                }
                if (i < 0 || i >= N || j - 2 < 0 || j - 2 >= N) {
                    result += luudd;
                } else {
                    map[i][j - 2] += (int) (map[i][j] * (0.02));
                }

                int lll = (int) (map[i][j] * (0.05));
                if (i - 2 < 0 || i - 2 >= N || j < 0 || j >= N) {
                    result += lll;
                } else {
                    map[i - 2][j] += (int) (map[i][j] * (0.05));
                }

                int a = Math.max(map[i][j] - (lrud + lud + llud + luudd + lll), 0);//0보다 작으면 그냥 0
                if (i - 1 < 0 || i - 1 >= N || j < 0 || j >= N) {
                    map[i - 1][j] += a;
                } else {
                    result += a;
                }

            }
            if (i == 1 && j == 1) {
                break;
            }
            //하
            for (int k = 0; k < move; k++) {
                j = j + move;
                int lrud = (int) (map[i][j] * (0.01));
                if (i - 1 < 0 || i - 1 >= N || j - 1 < 0 || j - 1 >= N) {
                    result += lrud;
                } else {
                    map[i - 1][j - 1] += (int) (map[i][j] * (0.01));
                }
                if (i + 1 < 0 || i + 1 >= N || j - 1 < 0 || j - 1 >= N) {
                    result += lrud;
                } else {
                    map[i + 1][j - 1] += (int) (map[i][j] * (0.01));
                }

                int lud = (int) (map[i][j] * (0.07));
                if (i + 1 < 0 || i + 1 >= N || j < 0 || j >= N) {
                    result += lrud;
                } else {
                    map[i + 1][j] += (int) (map[i][j] * (0.07));
                }
                if (i - 1 < 0 || i - 1 >= N || j < 0 || j >= N) {
                    result += lrud;
                } else {
                    map[i - 1][j] += (int) (map[i][j] * (0.07));
                }

                int llud = (int) (map[i][j] * (0.1));
                if (i + 1 < 0 || i + 1 >= N || j + 1 < 0 || j + 1 >= N) {
                    result += llud;
                } else {
                    map[i + 1][j + 1] += (int) (map[i][j] * (0.1));
                }
                if (i - 1 < 0 || i - 1 >= N || j + 1 < 0 || j + 1 >= N) {
                    result += llud;
                } else {
                    map[i - 1][j + 1] += (int) (map[i][j] * (0.1));
                }

                int luudd = (int) (map[i][j] * (0.02));
                if (i + 2 < 0 || i + 2 >= N || j < 0 || j >= N) {
                    result += luudd;
                } else {
                    map[i + 2][j] += (int) (map[i][j] * (0.02));
                }
                if (i - 2 < 0 || i - 2 >= N || j < 0 || j >= N) {
                    result += luudd;
                } else {
                    map[i - 2][j] += (int) (map[i][j] * (0.02));
                }

                int lll = (int) (map[i][j] * (0.05));
                if (i < 0 || i >= N || j + 2 < 0 || j + 2 >= N) {
                    result += lll;
                } else {
                    map[i][j + 2] += (int) (map[i][j] * (0.05));
                }

                int a = Math.max(map[i][j] - (lrud + lud + llud + luudd + lll), 0);//0보다 작으면 그냥 0
                if (i < 0 || i >= N || j + 1 < 0 || j + 1 >= N) {
                    map[i][j + 1] += a;
                } else {
                    result += a;
                }

            }
            move += 1;
            //우
            for (int k = 0; k < move; k++) {
                i = i + move;
                int lrud = (int) (map[i][j] * (0.01));
                if (i - 1 < 0 || i - 1 >= N || j - 1 < 0 || j - 1 >= N) {
                    result += lrud;
                } else {
                    map[i - 1][j - 1] += (int) (map[i][j] * (0.01));
                }
                if (i - 1 < 0 || i - 1 >= N || j + 1 < 0 || j + 1 >= N) {
                    result += lrud;
                } else {
                    map[i - 1][j + 1] += (int) (map[i][j] * (0.01));
                }

                int lud = (int) (map[i][j] * (0.07));
                if (i < 0 || i >= N || j + 1 < 0 || j + 1 >= N) {
                    result += lrud;
                } else {
                    map[i][j + 1] += (int) (map[i][j] * (0.07));
                }
                if (i < 0 || i >= N || j - 1 < 0 || j - 1 >= N) {
                    result += lrud;
                } else {
                    map[i][j - 1] += (int) (map[i][j] * (0.07));
                }

                int llud = (int) (map[i][j] * (0.1));
                if (i + 1 < 0 || i + 1 >= N || j + 1 < 0 || j + 1 >= N) {
                    result += llud;
                } else {
                    map[i + 1][j + 1] += (int) (map[i][j] * (0.1));
                }
                if (i + 1 < 0 || i + 1 >= N || j - 1 < 0 || j - 1 >= N) {
                    result += llud;
                } else {
                    map[i + 1][j - 1] += (int) (map[i][j] * (0.1));
                }

                int luudd = (int) (map[i][j] * (0.02));
                if (i < 0 || i >= N || j - 2 < 0 || j - 2 >= N) {
                    result += luudd;
                } else {
                    map[i][j - 2] += (int) (map[i][j] * (0.02));
                }
                if (i < 0 || i >= N || j + 2 < 0 || j + 2 >= N) {
                    result += luudd;
                } else {
                    map[i][j + 2] += (int) (map[i][j] * (0.02));
                }

                int lll = (int) (map[i][j] * (0.05));
                if (i < 0 || i >= N || j + 2 < 0 || j + 2 >= N) {
                    result += lll;
                } else {
                    map[i][j + 2] += (int) (map[i][j] * (0.05));
                }

                int a = Math.max(map[i][j] - (lrud + lud + llud + luudd + lll), 0);//0보다 작으면 그냥 0
                if (i + 1 < 0 || i + 1 >= N || j < 0 || j >= N) {
                    map[i + 1][j] += a;
                } else {
                    result += a;
                }
            }
            //상
            for (int k = 0; k < move; k++) {
                j = j - move;
                int lrud = (int) (map[i][j] * (0.01));
                if (i + 1 < 0 || i + 1 >= N || j - 1 < 0 || j - 1 >= N) {
                    result += lrud;
                } else {
                    map[i + 1][j - 1] += (int) (map[i][j] * (0.01));
                }
                if (i - 1 < 0 || i - 1 >= N || j - 1 < 0 || j - 1 >= N) {
                    result += lrud;
                } else {
                    map[i - 1][j - 1] += (int) (map[i][j] * (0.01));
                }

                int lud = (int) (map[i][j] * (0.07));
                if (i - 1 < 0 || i - 1 >= N || j < 0 || j >= N) {
                    result += lrud;
                } else {
                    map[i - 1][j] += (int) (map[i][j] * (0.07));
                }
                if (i + 1 < 0 || i + 1 >= N || j < 0 || j >= N) {
                    result += lrud;
                } else {
                    map[i + 1][j] += (int) (map[i][j] * (0.07));
                }

                int llud = (int) (map[i][j] * (0.1));
                if (i - 1 < 0 || i - 1 >= N || j + 1 < 0 || j + 1 >= N) {
                    result += llud;
                } else {
                    map[i - 1][j + 1] += (int) (map[i][j] * (0.1));
                }
                if (i + 1 < 0 || i + 1 >= N || j + 1 < 0 || j + 1 >= N) {
                    result += llud;
                } else {
                    map[i + 1][j + 1] += (int) (map[i][j] * (0.1));
                }

                int luudd = (int) (map[i][j] * (0.02));
                if (i + 2 < 0 || i + 2 >= N || j < 0 || j >= N) {
                    result += luudd;
                } else {
                    map[i + 2][j] += (int) (map[i][j] * (0.02));
                }
                if (i - 2 < 0 || i - 2 >= N || j < 0 || j >= N) {
                    result += luudd;
                } else {
                    map[i - 2][j] += (int) (map[i][j] * (0.02));
                }

                int lll = (int) (map[i][j] * (0.05));
                if (i < 0 || i >= N || j - 2 < 0 || j - 2 >= N) {
                    result += lll;
                } else {
                    map[i][j - 2] += (int) (map[i][j] * (0.05));
                }

                int a = Math.max(map[i][j] - (lrud + lud + llud + luudd + lll), 0);//0보다 작으면 그냥 0
                if (i < 0 || i >= N || j - 1 < 0 || j - 1 >= N) {
                    map[i][j - 1] += a;
                } else {
                    result += a;
                }
                if (move != N - 1) {
                    move += 1;
                }

            }
            System.out.println(result);
        }

    }
}
