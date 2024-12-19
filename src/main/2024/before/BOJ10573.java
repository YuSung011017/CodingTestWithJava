package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ10573 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] testCase = new int[n];
        for(int i = 0; i<n; i++){
            testCase[i] = Integer.parseInt(br.readLine());
        }
        int [] answer = new int [n];
        for(int i = 0; i<n; i++){
            int temp = testCase[i];
            ArrayList<Integer> tempArr = new ArrayList<>();
            //while()
        }
    }
}
