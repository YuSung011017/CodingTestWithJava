package day3;

public class MoreAndeMore2 {
    public static int solution(int a, int b) {
        int ab = Integer.parseInt(a + "" + b);
        if(2 * a * b <= ab) {
            return ab;
        } else {
            return 2 * a * b;
        }
    }
    public static void main(String[] args) {
        System.out.println(solution(2,91));
        System.out.println(solution(91,2));
    }
}
