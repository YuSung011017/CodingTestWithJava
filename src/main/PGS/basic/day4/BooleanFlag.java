package day4;

public class BooleanFlag {
    public static int solution(int a, int b, boolean flag) {
        return (flag) ? a+b : a-b;
    }

    public static void main(String[] args) {
        System.out.println(solution(-4,7,false));
    }
}
