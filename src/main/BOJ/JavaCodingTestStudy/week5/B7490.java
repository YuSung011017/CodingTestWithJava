package JavaCodingTestStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B7490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int [] test = new int[testCase];
        for(int i = 0; i < testCase; i++) {
            test[i] = Integer.parseInt(br.readLine());
        }
    }

}
