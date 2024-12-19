package day10;

public class StringFrontN {
    public static String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("ProgrammerS123",11));
    }
}
