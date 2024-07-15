package day9;

public class ValidationString {
    public static int solution(String my_string, String is_suffix) {
        int result = 0;
        String [] answer = new String[my_string.length()];
        for(int i = 0; i<my_string.length(); i++){
            answer[i] = my_string.substring(i,my_string.length());
        }
        for(int i = 0; i< answer.length; i++){
            if(answer[i].equals(is_suffix))
                result = 1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(solution("banana","ana"));

    }
}

