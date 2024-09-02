import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15650 {
    //자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    //고른 수열은 오름차순이어야 한다.
    static int n,m;
    static ArrayList<Integer>arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        recur(0);

    }
    static void recur(int num){
        if (num == m) {
            // 출력 형식 수정: ArrayList의 요소를 공백으로 구분하여 출력
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i));
                if (i < arr.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();  // 수열이 끝나면 줄 바꿈
            return;
        }
        for(int i =1; i<=n; i++){
            if(!arr.contains(i)){
                // arr가 공백이거나 or 공백이 아니라면 i는 arr의 가장 최근에 추가된 수보다 커지게 한다 그렇다면 자연히 오름차순으로 만들어진다.
                if(arr.isEmpty() || i>arr.get(arr.size()-1)){
                arr.add(i);
                recur(num + 1);
                arr.remove(arr.size() - 1);
                }
            }
        }
    }
}
