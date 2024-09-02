package JavaCodingTestStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class SEA8501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int [] n = new int[tc];
        for(int i = 0; i < tc; i++) {
            n[i] = Integer.parseInt(br.readLine());

        }
        for(int i = 0; i < tc; i++) {
            System.out.println("#"+(i+1)+" " +(solve(n[i])));
        }
    }
    static int solve(int n){
        Integer [] arr = new Integer[n];
        boolean[] barr = new boolean[n];
        for(int i = 0; i < n; i++) {
            arr[i] = (i+1);
        }
        int count = 0;
        while(true) {
            for (int i = 0; i < n; i++) {
                int j = i + 1;
                while (j < n) {
                    if (arr[i] < arr[j])
                        barr[j] = !barr[j];
                    j++;
                }
            }
            for (int i = 0; i < n; i++) {
                if(barr[i]) {
                    count++;
                }
            }
            int temp;
            for (int i = 0; i < n-1; i++) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }

            if(arr[0]==1)
                break;
        }
        Arrays.sort(arr,Collections.reverseOrder());
        barr = new boolean[n];
        while(true) {
            for (int i = 0; i < n; i++) {
                int j = i + 1;
                while (j < n) {
                    if (arr[i] < arr[j])
                        barr[j] = !barr[j];
                    j++;
                }
            }
            for (int i = 0; i < n; i++) {
                if(barr[i]) {
                    count++;
                }
            }
            int temp;
            for (int i = 0; i < n-1; i++) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }

            if(arr[0]==n)
                break;
        }
        return count;
    }
}
