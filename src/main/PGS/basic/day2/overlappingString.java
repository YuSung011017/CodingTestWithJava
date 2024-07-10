package day2;

import java.util.Scanner;

public class overlappingString {
    public static String solution(String my_string, String overwrite_string, int s) {
        //case 1  my_string.length() - s > overwrite_string.length()
        //case 2  my_string.length() - s <= overwrite_string.length()
        String answer = "";
        if(my_string.length() - s <= overwrite_string.length())
            answer = my_string.substring(0,s) + overwrite_string;
        else if (my_string.length() - s > overwrite_string.length()) {
            answer = my_string.substring(0,s) + overwrite_string +
                    my_string.substring(s+overwrite_string.length(),my_string.length());
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("insert a :");
        String a = scanner.next();
        System.out.print("insert b:");
        String b = scanner.next();
        System.out.print("insert c :");
        int c = scanner.nextInt();
        String str = solution(a,b,c);
        System.out.println();
        System.out.println(str);
    }
}
