package day10;

public class ReadingLength {
    public static String solution(String my_string, int m, int c) {
        char [][]answer = new char[my_string.length()/m][m];
        int k = 0;
        for(int i = 0; i<my_string.length()/m;i++){
            for(int j = 0; j<m;j++){
                answer[i][j] = my_string.charAt(k);
                k++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< answer.length;i++){
            sb.append(answer[i][c-1]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("ihrhbakrfpndopljhygc",4,2));
    }
}
