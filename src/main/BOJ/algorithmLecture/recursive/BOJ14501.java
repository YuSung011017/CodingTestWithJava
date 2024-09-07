import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    static int n;
    static int [][] interview;
    static int maxMoney;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        interview = new int [n+1][2];
        for(int i = 1; i<=n; i++){
            StringTokenizer st=  new StringTokenizer(br.readLine());
            interview[i][0] = Integer.parseInt(st.nextToken());
            interview[i][1] = Integer.parseInt(st.nextToken());
        }
        maxMoney = Integer.MIN_VALUE;
        recur(1,0);
        System.out.println(maxMoney);
    }
    static void recur(int num, int price){
        if(num > n){
            if(num > n+1){
                return;
            }
            else{
                maxMoney = Math.max(maxMoney,price);
                return;
            }
        }
        //상담을 받는다면
        recur(num + interview[num][0],price + interview[num][1]);

        //상담을 받지 않는다면
        recur(num+1,price);

    }
}
