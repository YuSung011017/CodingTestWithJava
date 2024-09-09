package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660_test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int map[][] = new int[4][4];
        int prefix[][] = new int[5][5];
        for(int i = 0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<4; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        for(int y = 0; y<4; y++){
            for(int x = 0; x<4; x++){
                prefix[y+1][x+1] = prefix[y][x+1] + prefix[y+1][x] - prefix[y][x] + map[y][x];
            }
        }

        int answer = prefix[y2][x2] - prefix[y1-1][x2] - prefix[y2][x1-1] + prefix[y1-1][x1-1];
        System.out.println(answer);
    }
}
//1 2 3 4
//2 3 4 5
//3 4 5 6
//4 5 6 7
//2 2 3 4