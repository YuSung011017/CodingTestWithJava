package BOJ_class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tempStar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = "*";
        String temp = "";
        for(int i = 0; i<N; i++){
            temp += str;
            System.out.println(temp);
        }

    }
}
