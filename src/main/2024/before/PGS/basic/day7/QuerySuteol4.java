package day7;

public class QuerySuteol4 {
    static int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            for(int j = queries[i][0]; j<= queries[i][1]; j++){
                if(j % queries[i][2] == 0){
                    arr[j] += 1;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int [] arr = {0,1,2,4,3};
        int [][] queries = {{0,4,1},{0,3,2},{0,3,3}};
        int result [] = solution(arr,queries);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
