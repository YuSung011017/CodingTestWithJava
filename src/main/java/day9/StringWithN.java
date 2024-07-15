package day9;

public class StringWithN {
    public static StringBuilder solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();
        for(int i = my_string.length()-n; i<my_string.length(); i++){
            answer.append(my_string.charAt(i));
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("ProgrammerS123",11));
    }
}
