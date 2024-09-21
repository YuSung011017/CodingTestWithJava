import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20056 {
    static int[][] delta = new int[][]{
            {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}
    };

    static int N,M,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<FireBall>[][] map = new Queue[N][N];
        Queue<FireBall> waitingList = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayDeque<>();
            }
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); //0

            waitingList.add(new FireBall(r,c,m,s,d));
        }

        for (int i = 0; i < K; i++) {
            moveFireBall(map,waitingList); // waitinglist의 파이어볼 이동
            divideFireBall(map, waitingList); // 파이어볼 나누기
        }

        int ans = 0;
        while (!waitingList.isEmpty()) {
            ans += waitingList.poll().weight;
        }
        System.out.println(ans);
    }

    private static void divideFireBall(Queue<FireBall>[][] map, Queue<FireBall> waitingList) {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x].isEmpty()) {
                    continue;
                } else if (map[y][x].size() == 1) {
                    waitingList.add(map[y][x].poll());
                } else { //나누기
                    int weightSum = 0;
                    int speedSum = 0;
                    int cnt = map[y][x].size();
                    boolean sameDelta = true;
                    boolean isEven = map[y][x].peek().d % 2 == 0;

                    while (!map[y][x].isEmpty()) {
                        FireBall fireBall = map[y][x].poll();
                        weightSum += fireBall.weight;
                        speedSum += fireBall.speed;
                        if (sameDelta && (isEven && fireBall.d % 2 == 1) || (!isEven && fireBall.d % 2 == 0)) {
                            sameDelta = false;
                        }
                    }

                    int startDelta = 0;
                    if (!sameDelta) {
                        startDelta = 1;
                    }

                    // 0 |||| 1
                    if (weightSum / 5 > 0) {
                        for (int i = 0; i < 4; i++) {
                            waitingList.add(new FireBall(y,x,weightSum / 5 , speedSum / cnt ,startDelta + i * 2 ));
                        }
                    }
                }
            }
        }

    }

    private static void moveFireBall(Queue<FireBall>[][] map, Queue<FireBall> waitingList) {
        while (!waitingList.isEmpty()) {
            FireBall fireBall = waitingList.poll();

            // 이동할 좌표 계산 (원형 격자 처리)
            int my = (fireBall.row + fireBall.speed * delta[fireBall.d][0]) % N;
            int mx = (fireBall.col + fireBall.speed * delta[fireBall.d][1]) % N;

            // 음수 좌표 처리 (Java에서는 모듈로 연산이 음수 결과를 반환할 수 있음)
            if (my < 0) my += N;
            if (mx < 0) mx += N;

            // 이동 후 FireBall의 좌표 업데이트
            fireBall.row = my;
            fireBall.col = mx;

            // 새로운 위치에 파이어볼 추가
            map[my][mx].add(fireBall);
        }
    }


}
class FireBall{
    int row,col,weight,speed,d;

    public FireBall(int row, int col, int weight, int speed, int d) {
        this.row = row;
        this.col = col;
        this.weight = weight;
        this.speed = speed;
        this.d = d;
    }
}

