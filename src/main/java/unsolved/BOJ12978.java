package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ12978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer>[] arr = new ArrayList[n];
        Boolean[] check = new Boolean[n];
        for (int i = 0; i < n; i++) {
            check[i] = false;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u - 1].add(v - 1);
            arr[v - 1].add(u - 1);
        }

        int answer = 0;
        while (true) {
            int max = 0;
            int maxIndex = 0;
            //영향권에 없고 가장 많은 도시와 연결된 도시
            for (int j = maxIndex; j < n; j++) {
                if (arr[j].size() > max && !check[j]) {
                    max = arr[j].size();
                    maxIndex = j;
                }
            }

            // maxIndex와 연결된 노드들을 모두 방문 처리
            for (int k = 0; k < arr[maxIndex].size(); k++) {
                check[arr[maxIndex].get(k)] = true;
            }
            check[maxIndex] = true;
            answer++;

            // 모든 노드가 방문되었는지 확인
            boolean allTrue = true;
            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    allTrue = false;
                    break;
                }
            }
            if (allTrue) {
                break;
            }
        }

        System.out.println(answer);
    }
}
