package day6;

public class ControlNum {
    public static int solution(int n, String control) {
       for(int i = 0; i<control.length(); i++) {
           if(control.charAt(i)=='w')
               n += 1;
           else if(control.charAt(i)=='s')
               n -= 1;
           else if(control.charAt(i)=='d')
               n += 10;
           else if(control.charAt(i)=='a')
               n -= 10;
       }
       return n;
    }
    public static void main(String[] args) {
        System.out.println(solution(0,"wsdawsdassw"));
    }
}
