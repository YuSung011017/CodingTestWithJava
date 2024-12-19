package day11;

public class CountChar {
    public static int[] solution(String my_string) {
        int [] answer = new int[52];
        for(int i = 0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                answer[c - 'A'] += 1;
            } else if (c >= 'a' && c <= 'z') {
                answer[c - 'a' + 26] += 1;
            }
        }
    return answer;
    }
    public static void main(String[] args) {
        String str = "Programmers";
        int [] answer = solution(str);
        for(int temp : answer){
           System.out.print(temp + " ");
        }
    }
}
