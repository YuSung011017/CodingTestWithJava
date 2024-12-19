package day6;

public class QuerySuYeol {
    public static int[] solution(int[] arr, int[][] queries) {
       for(int i = 0; i < queries.length; i++){
              int temp = arr[queries[i][0]];
              arr[queries[i][0]] = arr[queries[i][1]];
              arr[queries[i][1]] = temp;
       }
       return arr;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4};
        int quries[][] = {{0,3},{1,2},{1,4}};
        int answer[] = solution(arr,quries);
        for(int i = 0; i < arr.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
