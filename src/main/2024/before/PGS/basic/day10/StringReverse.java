package day10;

public class StringReverse {
    public static String solution(String my_string, int s, int e) {
       StringBuilder temp = new StringBuilder(my_string.substring(s,e+1));
       StringBuilder sb = new StringBuilder(my_string);
       sb.replace(s,e+1,temp.reverse().toString());
       return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("Progra21Sremm3",6,12));

    }
}
