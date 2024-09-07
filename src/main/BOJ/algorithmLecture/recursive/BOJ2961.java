import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961 {
    // 도영이는 짜파구리 요리사로 명성을 날렸었다. 이번에는 이전에 없었던 새로운 요리에 도전을 해보려고 한다.
    // 지금 도영이의 앞에는 재료가 N개 있다. 도영이는 각 재료의 신맛 S와 쓴맛 B를 알고 있다. 여러 재료를 이용해서 요리할 때,
    // 그 음식의 신맛은 사용한 재료의 신맛의 곱이고, 쓴맛은 합이다.
    // 시거나 쓴 음식을 좋아하는 사람은 많지 않다. 도영이는 재료를 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 만들려고 한다.
    // 또, 물을 요리라고 할 수는 없기 때문에, 재료는 적어도 하나 사용해야 한다.
    // 재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성하시오.
    static int N;
    static int [][] ingredient;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ingredient = new int[N][2];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken()); //sour
            ingredient[i][1] = Integer.parseInt(st.nextToken()); //bitter
        }
        answer = Integer.MAX_VALUE;
        recur(0,1,0,0);
        System.out.println(answer);
    }
    static void recur(int num,int sour, int bitter, int use){
        if(num == N){
            if(use==0){
                return;
            }
            int result = Math.abs(sour - bitter);
            answer = Math.min(answer,result);
            return;
        }
        recur(num+1,sour*ingredient[num][0],bitter+ingredient[num][1],use+1);
        recur(num+1,sour,bitter,use);
    }
}
