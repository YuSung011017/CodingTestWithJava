package day5;

public class EqualOrderSequence {
    public static int solution(int a, int d, boolean[] included) {
        int sum = 0;
        if(included[0])
            sum += a;
        for(int i = 1; i < included.length; i++) {
            a += d;
            if(included[i])
                sum += a;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(solution(3,4, new boolean[]{true, false, false, true, true}));
    }
}
