package day3;

public class MoreAndMore {
    public static int solution(int a, int b) {
        int answer = 0;
        String stra = String.valueOf(a);
        String strb = String.valueOf(b);
        String ab = stra + strb;
        String ba = strb + stra;
        int a1 = Integer.parseInt(ab);
        int b1 = Integer.parseInt(ba);
        if(a1>b1){
            answer = a1;
        }else if(b1>a1){
            answer = b1;
        }else{
            answer = a1;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(111,120));
    }
}
