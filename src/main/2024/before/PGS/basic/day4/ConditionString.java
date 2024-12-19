package day4;

public class ConditionString {
    public static int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        switch (ineq) {
            case ">":
                if(eq.equals("=")){
                    if(n>=m == true)
                        answer = 1;
                    else
                        answer = 0;
                } else if (eq.equals("!")) {
                    if(n > m == true)
                        answer = 1;
                    else
                        answer = 0;
                }
                break;
            case "<":
                if(eq.equals("=")){
                    if(n<=m == true)
                        answer = 1;
                    else
                        answer = 0;
                } else if (eq.equals("!")) {
                    if(n < m == true)
                        answer = 1;
                    else
                        answer = 0;
                }
                break;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(">", "!", 41, 78));
    }
}
