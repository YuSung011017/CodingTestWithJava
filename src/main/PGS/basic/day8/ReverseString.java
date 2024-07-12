public class ReverseString {
    public static StringBuilder solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for(int i = 0; i< queries.length; i++){
            String str = sb.substring(queries[i][0],queries[i][1]+1);
            String temp = new StringBuilder(str).reverse().toString();
            sb.replace(queries[i][0],queries[i][1]+1,temp);
        }
        return sb;
    }

    public static void main(String[] args) {
        String str = "rermgorpsam";
        int [][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};
        System.out.println(solution(str,queries));
    }
}
