package day9;

public class MakeAStringWithSubString {
    public static StringBuilder solution(String[] my_strings, int[][] parts) {
        StringBuilder answer = new StringBuilder();
       for(int i = 0; i< my_strings.length; i++){
           StringBuilder temp = new StringBuilder();
           for(int j = parts[i][0]; j<=parts[i][1]; j++){
               temp.append(my_strings[i].charAt(j));
           }
           answer.append(temp);
       }
       return answer;
    }
    public static void main(String[] args) {
        String [] my_string = {"progressive", "hamburger", "hammer", "ahocorasick"};
        int [][] parts = {{0, 4}, {1, 2}, {3, 5}, {7, 7}};
        System.out.println(solution(my_string,parts));
    }
}
