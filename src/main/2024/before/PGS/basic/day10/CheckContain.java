package day10;

public class CheckContain {
    public static int solution(String my_string, String is_prefix) {
        String [] str = new String[my_string.length()];
        for(int i = 0; i<my_string.length(); i++){
            str[0] = ""+my_string.charAt(0);
            if(i>0){
                str[i] = str[i-1]+my_string.charAt(i);
            }
        }
        for(int i = 0; i<str.length; i++){
            if(is_prefix.equals(str[i])){
                return 1;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(solution("banana","ban"));
    }
}
