package day9;

import java.util.Arrays;

public class MakeStringList {
    public static String[] solution(String my_string) {
       String [] answer = new String[my_string.length()];
       for(int i = 0; i<my_string.length(); i++){
           answer[i] = my_string.substring(i,my_string.length());
       }
       Arrays.sort(answer);
       return answer;
    }
    public static void main(String[] args) {
        String [] answer = solution("banana");
        for(String temp : answer){
            System.out.print(temp + " ");
        }
    }
}
