package day4;

public class OddEven {
    public static int solution(int n) {
        int sum = 0;
        if(n%2==0){
            for(int i =0; i<=n; i++){
                if(i%2==0)
                    sum += i*i;
            }
        }else{
            for(int i =0; i<=n; i++){
                if(i%2!=0)
                    sum += i;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
