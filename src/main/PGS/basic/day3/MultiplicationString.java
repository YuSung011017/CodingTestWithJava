package day3;

public class MultiplicationString {
    public static String solution(String my_string, int k) {
        String answer = "";
        for(int i = 0; i<k; i++){
            answer += my_string;
        }
        return answer;
    }
    public static void main(String[] args) {
        String my_string = "Hello World";
        String a = solution(my_string,3);
        System.out.println(a);
    }
}
