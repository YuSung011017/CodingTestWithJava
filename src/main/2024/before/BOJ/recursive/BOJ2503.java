import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2503 {
    static int n;
    static Baseball [] hint;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        hint = new Baseball[n];
        for (int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int expect = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            hint[i] = new Baseball(expect,strike,ball);
        }
        answer = 0;
        recur(0,100);
        System.out.println(answer);

    }
    static void recur(int hint_index,int num){
        if(hint_index == n){//모든 힌트를 통과했다면
            answer++; //정답의 갯수 1증가
            //System.out.println(num);
            recur(0,num+1);
            return;
        }
        if(num == 1000){//number가 1000이 된다면 answer을 return
            return ;
        }

        if(check(hint_index,num)){ //힌트를 통과하면
            recur(hint_index+1,num); //다음 힌트로
        }else{//힌트를 통과하지 못했다면
            recur(0,num+1);//다음 숫자 검사
        }

    }
    static boolean check(int hint_index, int num){
        int strike = 0;
        int ball = 0;
        int h_num = hint[hint_index].expect;
        int h_hundreds_digit = h_num/100;
        int h_tens_digit = (h_num - h_hundreds_digit *100)/10;
        int h_ones_digit = h_num % 10;

        int t_hundreds_digit = num/100;
        int t_tens_digit = (num - t_hundreds_digit *100)/10;
        int t_ones_digit = num % 10;

        if(t_hundreds_digit == t_tens_digit || t_hundreds_digit == t_ones_digit || t_tens_digit == t_ones_digit){
            //각 자리수는 서로 달라야하기 떄문
            return false;
        }
        if(t_hundreds_digit == 0 || t_tens_digit == 0 || t_ones_digit == 0){
            //각 자리수는 1~9까지의 자연수이기 떄문
            return false;
        }
        //검사 시작
        //힌트 배열에 있는 수와 각 자리의 수가 같다면 strike 1 증가
        if(t_hundreds_digit == h_hundreds_digit){
            strike++;
        }
        if(t_tens_digit == h_tens_digit){
            strike++;
        }
        if(t_ones_digit == h_ones_digit){
            strike++;
        }
        //같은 자리에 있지는 않지만 같은 수가 있다면 ball 1 증가
        if(t_hundreds_digit == h_tens_digit || t_hundreds_digit == h_ones_digit){
            ball++;
        }
        if(t_tens_digit == h_hundreds_digit || t_tens_digit == h_ones_digit){
            ball++;
        }
        if(t_ones_digit == h_tens_digit || t_ones_digit == h_hundreds_digit){
            ball++;
        }

        if(strike == hint[hint_index].strike && ball == hint[hint_index].ball){
            return true;
        }else{
            return false;
        }

    }
}
class Baseball{
    int expect;
    int strike;
    int ball;
    public Baseball(int expect, int strike, int ball) {
        this.expect = expect;
        this.strike = strike;
        this.ball = ball;
    }
}