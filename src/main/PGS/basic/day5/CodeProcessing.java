package day5;

import java.sql.SQLOutput;

public class CodeProcessing {
    public static String solution(String code) {
        int mode = 0;
        String ret ="";
        int idx =0;
        for(int i = 0; i < code.length(); i++) {
            if(mode == 0){
                if(code.charAt(i) != '1'&& i%2 == 0){
                    ret = ret + code.charAt(i);
                }else if(code.charAt(i)=='1'){
                    mode = 1;
                }
            }else if(mode == 1){
                if(code.charAt(i) != '1'&& i%2 == 1){
                    ret = ret + code.charAt(i);
                }else if(code.charAt(i)=='1'){
                    mode = 0;
                }
            }
        }
        if(ret.isEmpty())
            ret = "EMPTY";
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(solution("abc1abc1abc"));
    }
}
