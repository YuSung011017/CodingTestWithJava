public class DividedBy9 {
    public static int solution(String number) {
        int sum = 0;
        for(int i = 0; i<number.length(); i++) {
            sum += number.charAt(i)-'0';
        }
        return sum%9;
    }
    public static void main(String[] args) {
        System.out.println(solution("78720646226947352489"));
    }
}
